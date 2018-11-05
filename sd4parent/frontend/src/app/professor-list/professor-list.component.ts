import {Component, OnInit, TemplateRef} from "@angular/core";
import { Professor } from "../model/professor";
import  {ProfessorService } from "../service/professor.service";
import { Subscription } from "rxjs/internal/Subscription";
import { BsModalRef, BsModalService } from "ngx-bootstrap";


@Component({
  selector: 'professor-list',
  templateUrl: './professor-list.component.html',
})

export class ProfessorListComponent implements OnInit{

  public editMode = false;

  public professorList: Professor[];
  public editableBa: Professor = new Professor();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private professorListService : ProfessorService,
              private modalService: BsModalService){}

  ngOnInit() {
    this.loadProfessorList();
  }

  private loadProfessorList(): void {
    this.subscriptions.push(this.professorListService.getProfessorList().subscribe(listItem => {
      this.professorList = listItem as Professor[];
      console.log(this.professorList);
    }))
  }

  //открытие модального окна для изменения\добавления
  public _openModal(template: TemplateRef<any>, professorList: Professor) : void {
    if(professorList){
      this.editMode = true;
      this.editableBa = Professor.cloneBase(professorList);
    } else {
      this.refreshBa();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template);
  }

  public  _addProfessorList(): void {
    this.subscriptions.push(this.professorListService.saveProfessorList(this.editableBa).subscribe(()=>{
      this._updateProfessorList();
      this.refreshBa();
      this._closeModal();
    }));
  }

  public _deleteProfessorList(professorList: string) : void {
    this.subscriptions.push(this.professorListService.deleteProfessorList(professorList).subscribe(() => {
      this._updateProfessorList();
    }))
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  private refreshBa(): void {
    this.editableBa = new Professor();
  }

  public _updateProfessorList(): void {
    this.loadProfessorList();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}

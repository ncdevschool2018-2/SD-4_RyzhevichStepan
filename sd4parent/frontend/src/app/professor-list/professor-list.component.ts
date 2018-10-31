import {Component, OnInit, TemplateRef} from "@angular/core";
import { ProfessorList } from "../model/professor-list";
import  {ProfessorListService } from "../service/professor-list.service";
import { Subscription } from "rxjs/internal/Subscription";
import { BsModalRef, BsModalService } from "ngx-bootstrap";


@Component({
  selector: 'professor-list',
  templateUrl: './professor-list.component.html',
})

export class ProfessorListComponent implements OnInit{

  public editMode = false;

  public professorList: ProfessorList[];
  public editableBa: ProfessorList = new ProfessorList();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private professorListService : ProfessorListService,
              private modalService: BsModalService){}

  ngOnInit() {
    this.loadProfessorList();
  }

  private loadProfessorList(): void {
    this.subscriptions.push(this.professorListService.getProfessorList().subscribe(listItem => {
      this.professorList = listItem as ProfessorList[];
      console.log(this.professorList);
    }))
  }

  //открытие модального окна для изменения\добавления
  public _openModal(template: TemplateRef<any>, professorList: ProfessorList) : void {
    if(professorList){
      this.editMode = true;
      this.editableBa = ProfessorList.cloneBase(professorList);
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
    this.editableBa = new ProfessorList();
  }

  public _updateProfessorList(): void {
    this.loadProfessorList();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}

import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import { Professor } from "../model/professor";
import  {ProfessorService } from "../service/professor.service";
import { Subscription } from "rxjs/internal/Subscription";
import { BsModalRef, BsModalService } from "ngx-bootstrap";


@Component({
  selector: 'professor-list',
  templateUrl: './professor.component.html',
})

export class ProfessorComponent implements OnInit, OnDestroy{

  public editMode = false;

  public professor: Professor[];
  public editableProfessor: Professor = new Professor();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private professorService : ProfessorService,
              private modalService: BsModalService){}

  ngOnInit() {
    this.loadProfessors();
  }

  private loadProfessors(): void {
    this.subscriptions.push(this.professorService.getProfessor().subscribe(listItem => {
      this.professor = listItem as Professor[];
      console.log(this.professor);
    }))
  }

  //открытие модального окна для изменения\добавления
  public openModal(template: TemplateRef<any>, professor: Professor) : void {
    if(professor){
      this.editMode = true;
      this.editableProfessor = Professor.cloneBase(professor);
    } else {
      this.refreshBa();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template);
  }

  public  addProfessor(): void {
    this.subscriptions.push(this.professorService.saveProfessorList(this.editableProfessor).subscribe(()=>{
      this.updateProfessor();
      this.refreshBa();
      this.closeModal();
    }));
  }

  public deleteProfessor(professor: string) : void {
    this.subscriptions.push(this.professorService.deleteProfessor(professor).subscribe(() => {
      this.updateProfessor();
    }))
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  private refreshBa(): void {
    this.editableProfessor = new Professor();
  }

  public updateProfessor(): void {
    this.loadProfessors();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}

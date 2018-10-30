import {Component, HostListener, Input, OnInit, TemplateRef} from "@angular/core";
import { StudentList } from "../model/student-list";
import  {StudentListService } from "../service/student-list.service";
import { Subscription } from "rxjs/internal/Subscription";
import { BsModalRef, BsModalService } from "ngx-bootstrap";

@Component({
  selector: 'student-list',
  templateUrl: './student-list.component.html',
})

export class StudentListComponent implements OnInit{
  public editMode = false;

  public studentList: StudentList[];
  public editableBa: StudentList = new StudentList();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private studentListService : StudentListService,
              private modalService: BsModalService){}

  ngOnInit() {
    this.loadStudentList();
  }

  private loadStudentList(): void {
    this.subscriptions.push(this.studentListService.getStudentList().subscribe(listItem => {
      this.studentList = listItem as StudentList[];
      console.log(this.studentList);
    }))
  }

  //открытие модального окна для изменения\добавления
  public _openModal(template: TemplateRef<any>, studList: StudentList) : void {
    if(studList){
      this.editMode = true;
      this.editableBa = StudentList.cloneBase(studList);
    } else {
      this.refreshBa();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template);
  }

  public  _addStudentList(): void {
    this.subscriptions.push(this.studentListService.saveStudentList(this.editableBa).subscribe(()=>{
      this._updateStudentList();
      this.refreshBa();
      this._closeModal();
    }));
  }

  public _deleteStudentList(studentList: string) : void {
    this.subscriptions.push(this.studentListService.deleteStudentList(studentList).subscribe(() => {
      this._updateStudentList();
    }))
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  private refreshBa(): void {
    this.editableBa = new StudentList();
  }

  public _updateStudentList(): void {
    this.loadStudentList();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  @Input('sortable-column')
  columnName: string;

  @Input('sort-derection')
  sortDirection: string='';

  @HostListener('click')
  sort() {
    this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
  }
}

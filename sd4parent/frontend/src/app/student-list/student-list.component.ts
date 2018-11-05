import {Component, HostListener, Input, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import { Student } from "../model/student";
import  {StudentService } from "../service/student.service";
import { Subscription } from "rxjs/internal/Subscription";
import { BsModalRef, BsModalService } from "ngx-bootstrap";
import {StudentsGroup} from "../model/studentsgroup";
import {StudentsGroupService} from "../service/studentsgroup.service";
import {Faculty} from "../model/faculty";
import {FacultyService} from "../service/faculty.service";

@Component({
  selector: 'student-list',
  templateUrl: './student-list.component.html',
})

export class StudentListComponent implements OnInit, OnDestroy{
  public editMode = false;

  public studentList: Student[];
  public editableStudent: Student = new Student();
  public modalRef: BsModalRef;


  private subscriptions: Subscription[] = [];

  constructor(private studentListService : StudentService,
              private groupService : StudentsGroupService,
              private facultyService: FacultyService,
              private modalService: BsModalService){}

  ngOnInit() {
    this.loadStudentList();
    this.editableStudent.group = new StudentsGroup();
    this.editableStudent.group.faculty = new Faculty();
  }

  private loadStudentList(): void {
    this.subscriptions.push(this.studentListService.getStudentList().subscribe(listItem => {
      this.studentList = listItem as Student[];
      console.log(this.studentList);
    }))
  }

  //открытие модального окна для изменения\добавления
  public _openModal(template: TemplateRef<any>, studList: Student) : void {
    if(studList){
      this.editMode = true;
      this.editableStudent = Student.cloneBase(studList);
    } else {
      this.refreshStudentList();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template);
  }

  public  _addStudentList(): void {
    // this.subscriptions.push(this.studentListService.saveStudentList(this.editableStudent).subscribe(()=>{

      this.subscriptions.push(this.groupService.getStudentsGroupById(this.editableStudent.group.id_group).subscribe((groupItem => {
        if(groupItem) {
          this.editableStudent.group = groupItem as StudentsGroup;
        } else return;

        if(this.editableStudent.group !== null)
          this.subscriptions.push(this.studentListService.saveStudentList(this.editableStudent).subscribe(()=> {
            this._updateStudentList();
            this.refreshStudentList();
        }));
    })));
      this.subscriptions.push(this.facultyService.getFacultyById(this.editableStudent.group.faculty.id_faculty).subscribe((facultyItem => {
        if(facultyItem){
          this.editableStudent.group.faculty = facultyItem as Faculty;
        } else return;
        if(this.editableStudent.group.faculty !== null)
          this.subscriptions.push(this.studentListService.saveStudentList(this.editableStudent).subscribe( ()=> {
            this._updateStudentList();
            this.refreshStudentList();
            this._closeModal();
          }))
      })))
  }

  public _deleteStudentList(studentList: string) : void {
    this.subscriptions.push(this.studentListService.deleteStudentList(studentList).subscribe(() => {
      this._updateStudentList();
    }))
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  private refreshStudentList(): void {
    this.editableStudent = new Student();
    this.editableStudent.group = new StudentsGroup();
    this.editableStudent.group.faculty = new Faculty();
  }

  public _updateStudentList(): void {
    this.loadStudentList();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}

import {Component, HostListener, Input, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import { Student } from "../model/student";
import  {StudentService } from "../service/student.service";
import { Subscription } from "rxjs/internal/Subscription";
import { BsModalRef, BsModalService } from "ngx-bootstrap";
import {StudentsGroup} from "../model/studentsGroup";
import {GroupService} from "../service/group.service";
import {Faculty} from "../model/faculty";
import {FacultyService} from "../service/faculty.service";


@Component({
  selector: 'student-list',
  templateUrl: './student.component.html',
})

export class StudentComponent implements OnInit, OnDestroy{
  public editMode = false;

  public students: Student[];
  public groups: StudentsGroup[];
  public faculties: Faculty[];

  public tempGroup: number;
  public tempFaculty: number;

  public editableStudent: Student = new Student();
  public modalRef: BsModalRef;


  private subscriptions: Subscription[] = [];

  constructor(private studentService : StudentService,
              private groupService : GroupService,
              private facultyService: FacultyService,
              private modalService: BsModalService){}

  ngOnInit() {
    this.loadStudents();
    this.loadGroups();
    this.loadFaculties();
    this.editableStudent.group = new StudentsGroup();
    this.editableStudent.group.faculty = new Faculty();
  }

  private loadStudents(): void {
    this.subscriptions.push(this.studentService.getStudentList().subscribe(listItem => {
      this.students = listItem as Student[];
      console.log(this.students);
    }))
  }

  private loadGroups(): void {
    this.subscriptions.push(this.groupService.getStudentsGroup().subscribe( groupItem =>{
      this.groups = groupItem as StudentsGroup[];
    }))
  }

  private loadFaculties(): void {
    this.subscriptions.push(this.facultyService.getFaculty().subscribe( facultyItem => {
      this.faculties = facultyItem as Faculty[];
    }))
  }

  //открытие модального окна для изменения\добавления
  public openModal(template: TemplateRef<any>, studList: Student) : void {
    if(studList){
      this.editMode = true;
      this.editableStudent = Student.cloneBase(studList);
      this.tempGroup = this.editableStudent.group.id_group;
      this.tempFaculty = this.editableStudent.group.faculty.id_faculty;
    } else {
      this.refreshStudent();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template);
  }

  // public checkGroup(): boolean {
  // var index: number = this.groups.indexOf(group);
  // console.log(index, group.name);
  //   if(group.faculty.id_faculty != this.tempFaculty){
  //     console.log(group);
  //   }
  //   else console.log("null");
  // }
  //
  public addStudent() : void {
      for(let group of this.groups) {
        if (this.tempGroup == group.id_group) {
          this.editableStudent.group = group;
        }
      }
      for (let faculty of this.faculties) {
        if(this.tempFaculty == faculty.id_faculty &&
          this.editableStudent.group.faculty.id_faculty == faculty.id_faculty) {
          this.editableStudent.group.faculty = faculty;
        }
      }

      this.subscriptions.push(this.studentService.saveStudentList(this.editableStudent).subscribe(() =>{
        this.updateStudent();
        this.refreshStudent();
        this.closeModal();
      }))


  }

  public deleteStudent(studentList: string) : void {
    this.subscriptions.push(this.studentService.deleteStudentList(studentList).subscribe(() => {
      this.updateStudent();
    }))
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  private refreshStudent(): void {
    this.editableStudent = new Student();
    this.editableStudent.group = new StudentsGroup();
    this.editableStudent.group.faculty = new Faculty();
  }

  public updateStudent(): void {
    this.loadStudents();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}

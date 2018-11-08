import {Component, OnDestroy, OnInit, TemplateRef} from "@angular/core";
import {Faculty} from "../model/faculty";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {GroupService} from "../service/group.service";
import {FacultyService} from "../service/faculty.service";
import {Subscription} from "rxjs";
import {StudentsGroup} from "../model/studentsGroup";


@Component({
  selector: 'group-list',
  templateUrl: './group.component.html',
})

export class GroupComponent implements OnInit, OnDestroy{
  public editMode = false;

  public groups : StudentsGroup[];
  public faculties: Faculty[];

  public tempFaculty;

  public editableGroup : StudentsGroup = new StudentsGroup();
  public modalRef: BsModalRef;
  private subscriptions: Subscription[] = [];

  constructor (private groupService: GroupService,
               private facultyService: FacultyService,
               private modalService: BsModalService) {}
  ngOnInit() {
    this.loadGroups();
    this.loadFaculties();
    this.editableGroup.faculty = new Faculty();
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

  public openModal(template: TemplateRef<any>, group: StudentsGroup) : void {
    if(group){
      this.editMode = true;
      this.editableGroup = StudentsGroup.cloneBase(group);
      this.tempFaculty = this.editableGroup.faculty.id_faculty;
    } else {
      this.refreshGroup();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public addGroup(): void {
    for (let faculty of this.faculties) {
      if(this.tempFaculty == faculty.id_faculty) {
        this.editableGroup.faculty = faculty;
      }
    }
    this.subscriptions.push(this.groupService.saveStudentsGroup(this.editableGroup).subscribe(() =>{
      this.updateGroup();
      this.refreshGroup();
      this.closeModal();
    }))
  }

  public deleteGroup(group: string) : void {
    this.subscriptions.push(this.groupService.deleteStudentsGroup(group).subscribe(() => {
      this.updateGroup();
    }))
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  private refreshGroup(): void {
    this.editableGroup = new StudentsGroup();
    this.editableGroup.faculty = new Faculty();
  }

  public updateGroup(): void {
    this.loadGroups();
  }
}



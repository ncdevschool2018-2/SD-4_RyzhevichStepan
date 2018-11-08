import {StudentsGroup} from "./studentsGroup";
import {groupBy} from "rxjs/internal/operators";

export class Student {
  id_student: string;
  firstname: string;
  secondname: string;
  patronymic: string;
  group: StudentsGroup;
  subgroup: string;
  course: string;
  telnumber: string;
  email: string;


  static cloneBase(studentList: Student) : Student {
    let clonedStudentList: Student = new Student();

    clonedStudentList.id_student = studentList.id_student;
    clonedStudentList.firstname = studentList.firstname;
    clonedStudentList.secondname = studentList.secondname;
    clonedStudentList.patronymic = studentList.patronymic;
    // clonedStudentList.group = StudentsGroup.cloneBase(students.group);
    clonedStudentList.group = studentList.group;
    clonedStudentList.course = studentList.group.course;
    clonedStudentList.subgroup = studentList.subgroup;
    clonedStudentList.telnumber = studentList.telnumber;
    clonedStudentList.email = studentList.email;

    return clonedStudentList;
  }
}

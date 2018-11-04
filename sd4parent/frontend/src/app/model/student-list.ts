import {StudentsGroup} from "./studentsgroup";

export class StudentList {
  id_student: string;
  firstname: string;
  secondname: string;
  patronymic: string;
  group: StudentsGroup;
  subgroup: string;
  course: string;
  telnumber: string;
  email: string;


  static cloneBase(studentList: StudentList) : StudentList {
    let clonedStudentList: StudentList = new StudentList();

    clonedStudentList.id_student = studentList.id_student;
    clonedStudentList.firstname = studentList.firstname;
    clonedStudentList.secondname = studentList.secondname;
    clonedStudentList.patronymic = studentList.patronymic;
    clonedStudentList.group = StudentsGroup.cloneBase(studentList.group);
    clonedStudentList.subgroup = studentList.subgroup;
    clonedStudentList.course = studentList.course;
    clonedStudentList.telnumber = studentList.telnumber;
    clonedStudentList.email = studentList.email;

    return clonedStudentList;
  }
}

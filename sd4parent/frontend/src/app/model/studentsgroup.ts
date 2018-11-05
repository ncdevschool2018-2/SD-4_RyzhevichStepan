import {Faculty} from "./faculty";

export class StudentsGroup{
  id_group: number;
  name: string;
  faculty: Faculty;
  course: string;

  static cloneBase(studentsGroup: StudentsGroup) : StudentsGroup {
    let clonedStudentsGroup: StudentsGroup = new StudentsGroup();

    clonedStudentsGroup.id_group = studentsGroup.id_group;
    clonedStudentsGroup.name = studentsGroup.name;
    clonedStudentsGroup.faculty = studentsGroup.faculty;
    clonedStudentsGroup.course = studentsGroup.course;

    return clonedStudentsGroup;
  }
}

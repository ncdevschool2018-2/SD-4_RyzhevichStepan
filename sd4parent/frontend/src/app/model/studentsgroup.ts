
export class StudentsGroup{
  id_group: string;
  name: string;
  id_faculty: string;

  static cloneBase(studentsGroup: StudentsGroup) : StudentsGroup {
    let clonedStudentsGroup: StudentsGroup = new StudentsGroup();

    clonedStudentsGroup.id_group = studentsGroup.id_group;
    clonedStudentsGroup.name = studentsGroup.name;
    clonedStudentsGroup.id_faculty = studentsGroup.id_faculty;

    return clonedStudentsGroup;
  }
}

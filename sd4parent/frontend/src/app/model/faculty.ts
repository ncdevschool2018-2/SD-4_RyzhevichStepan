
export class Faculty {
    id_faculty: number;
    name: string;

  static cloneBase(faculty: Faculty) : Faculty {
    let clonedFaculty: Faculty = new Faculty();

    clonedFaculty.id_faculty = faculty.id_faculty;
    clonedFaculty.name = faculty.name;

    return clonedFaculty;
  }
}

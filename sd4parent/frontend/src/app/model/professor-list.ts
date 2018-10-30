export class ProfessorList {
  id_professor: string;
  firstname: string;
  secondname: string;
  patronymic: string;
  telnumber: string;
  email: string;

  static cloneBase(professorList: ProfessorList) : ProfessorList {
    let clonedProfessorList: ProfessorList = new ProfessorList();

    clonedProfessorList.id_professor = professorList.id_professor;
    clonedProfessorList.firstname = professorList.firstname;
    clonedProfessorList.secondname = professorList.secondname;
    clonedProfessorList.patronymic = professorList.patronymic;
    clonedProfessorList.telnumber = professorList.telnumber;
    clonedProfessorList.email = professorList.email;

    return clonedProfessorList;
  }
}

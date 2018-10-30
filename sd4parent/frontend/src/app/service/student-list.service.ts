import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {StudentList} from "../model/student-list";

@Injectable({
  providedIn: 'root'
})

export class StudentListService {
  constructor(private http: HttpClient){}

  getStudentList() : Observable<StudentList[]> {
    return this.http.get<StudentList[]>('/api/stlist');
  }

  saveStudentList(studentList: StudentList) : Observable<StudentList> {
    return this.http.post<StudentList>('api/stlist', studentList);
  }

  deleteStudentList(studentList: string) : Observable<void> {
    return this.http.delete<void>('api/stlist/' + studentList);
  }
}

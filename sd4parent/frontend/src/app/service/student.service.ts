import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {Student} from "../model/student";

@Injectable({
  providedIn: 'root'
})

export class StudentService {
  constructor(private http: HttpClient){}

  getStudentList() : Observable<Student[]> {
    return this.http.get<Student[]>('/api/stlist');
  }

  saveStudentList(studentList: Student) : Observable<Student> {
    return this.http.post<Student>('api/stlist', studentList);
  }

  deleteStudentList(studentList: string) : Observable<void> {
    return this.http.delete<void>('api/stlist/' + studentList);
  }
}

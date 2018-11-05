import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Faculty} from "../model/faculty";

@Injectable({
  providedIn: 'root'
})

export class FacultyService {
  constructor(private http: HttpClient) {}

  getFacultyById(id: number): Observable<Faculty> {
    return this.http.get<Faculty>('/api/fc/' + id);
  }

  saveStudentsGroup(faculty: Faculty) : Observable<Faculty> {
    return this.http.post<Faculty>('api/fc/', faculty);
  }

  deleteStudentsGroup(faculty: string) : Observable<void> {
    return this.http.delete<void>('api/fc/' + faculty);
  }
}

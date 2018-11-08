import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Faculty} from "../model/faculty";

@Injectable({
  providedIn: 'root'
})

export class FacultyService {
  constructor(private http: HttpClient) {}

  getFaculty() : Observable<Faculty[]> {
    return this.http.get<Faculty[]>('api/fc/');
  }

  getFacultyById(id: number): Observable<Faculty> {
    return this.http.get<Faculty>('/api/fc/' + id);
  }

  saveFaculty(faculty: Faculty) : Observable<Faculty> {
    return this.http.post<Faculty>('api/fc/', faculty);
  }

  deleteFaculty(faculty: string) : Observable<void> {
    return this.http.delete<void>('api/fc/' + faculty);
  }
}

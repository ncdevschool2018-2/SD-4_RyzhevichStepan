import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {Professor} from "../model/professor";

@Injectable({
  providedIn: 'root'
})

export class ProfessorService {
  constructor(private http: HttpClient){}

  getProfessorList() : Observable<Professor[]> {
    return this.http.get<Professor[]>('/api/prlist');
  }

  saveProfessorList(professorList: Professor) : Observable<Professor> {
    return this.http.post<Professor>('api/prlist', professorList);
  }

  deleteProfessorList(professorList: string) : Observable<void> {
    return this.http.delete<void>('api/prlist/' + professorList);
  }
}

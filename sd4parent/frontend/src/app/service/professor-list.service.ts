import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {ProfessorList} from "../model/professor-list";

@Injectable({
  providedIn: 'root'
})

export class ProfessorListService {
  constructor(private http: HttpClient){}

  getProfessorList() : Observable<ProfessorList[]> {
    return this.http.get<ProfessorList[]>('/api/prlist');
  }

  saveProfessorList(professorList: ProfessorList) : Observable<ProfessorList> {
    return this.http.post<ProfessorList>('api/prlist', professorList);
  }

  deleteProfessorList(professorList: string) : Observable<void> {
    return this.http.delete<void>('api/prlist/' + professorList);
  }
}

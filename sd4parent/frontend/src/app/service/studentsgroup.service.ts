import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {StudentsGroup} from "../model/studentsgroup";

@Injectable({
  providedIn: 'root'
})

export class StudentsGroupService {
  constructor(private http: HttpClient) {}

  getStudentsGroupById(id: number): Observable<StudentsGroup> {
    return this.http.get<StudentsGroup>('/api/gr/' + id);
  }


  saveStudentsGroup(group: StudentsGroup) : Observable<StudentsGroup> {
    return this.http.post<StudentsGroup>('api/gr/', group);
  }

  deleteStudentsGroup(group: string) : Observable<void> {
    return this.http.delete<void>('api/gr/' + group);
  }
}

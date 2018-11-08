import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {StudentsGroup} from "../model/studentsGroup";

@Injectable({
  providedIn: 'root'
})

export class GroupService {
  constructor(private http: HttpClient) {}


  getStudentsGroup() : Observable<StudentsGroup[]> {
    return this.http.get<StudentsGroup[]>('api/gr/');
  }

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

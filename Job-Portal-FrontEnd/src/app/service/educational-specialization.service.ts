import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {EducationalSpecialization} from "../dto/educational-specialization";
import {MAIN_URL} from "./user-service.service";
import {Category} from "../dto/category";

const URLS="/api/v1/EducationalSpecialization"
@Injectable()
export class EducationalSpecializationService {

  constructor(private http:HttpClient) { }

  saveEducationalSpecialization(educationalSpecialization:EducationalSpecialization):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS,educationalSpecialization);
  }


  getAllEducationalSpecialization():Observable<Array<EducationalSpecialization>>{
    return this.http.get<Array<EducationalSpecialization>>(MAIN_URL+URLS);
  }
}

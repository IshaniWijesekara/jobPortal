import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {Industry} from "../dto/industry";
import {MAIN_URL} from "./user-service.service";

const URLS="/api/v1/Industry"

@Injectable()
export class IndustryService {

  constructor(private http:HttpClient) { }

  saveIndustry(industry:Industry):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS,industry);
  }

  getAllIndustry():Observable<Array<Industry>>{
    return this.http.get<Array<Industry>>(MAIN_URL+URLS);
  }
}

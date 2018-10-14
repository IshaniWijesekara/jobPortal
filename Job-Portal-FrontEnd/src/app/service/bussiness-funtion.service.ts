import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {BussinessFuntion} from "../dto/bussiness-funtion";
import {MAIN_URL} from "./user-service.service";

const URLS="/api/v1/BussinesFuntion"
@Injectable()
export class BussinessFuntionService {

  constructor(private http:HttpClient) { }

  addBussinessFuntion(bussinessFuntion:BussinessFuntion):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS,bussinessFuntion);
  }

  getAllBussinessFuntion():Observable<Array<BussinessFuntion>>{
    return this.http.get<Array<BussinessFuntion>>(MAIN_URL+URLS);
  }
}

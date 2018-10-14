import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";
import {Category} from "../dto/category";
import {MAIN_URL} from "./user-service.service";

const URLS="/api/v1/category"
@Injectable()
export class CategoryService {

  constructor(private http:HttpClient) { }

  addCategory(category:Category):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS,category);
  }

  getAllCategory():Observable<Array<Category>>{
    return this.http.get<Array<Category>>(MAIN_URL+URLS);
  }
}

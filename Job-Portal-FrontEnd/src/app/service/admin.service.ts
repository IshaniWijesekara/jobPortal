import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AdminProfile} from "../dto/admin-profile";
import {Observable} from "rxjs/index";
import {MAIN_URL} from "./user-service.service";

const URLS="/api/v1/admin"
@Injectable()
export class AdminService {

  constructor(private http:HttpClient) { }

  saveAdminProfile(adminProfile:AdminProfile):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS,adminProfile);
  }

  uploadFile(formData:FormData):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URLS+"/file",formData);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../dto/user";
import {Observable} from "rxjs/index";
import {MAIN_URL} from "./user-service.service";
import {Router} from "@angular/router";
import {map} from "rxjs/internal/operators";
import {Login} from "../dto/login";
import {Users} from "../dto/users";

const URL="/api/v1/login"
@Injectable()
export class AuthService {

  users:Users=new Users();


  constructor(private http:HttpClient,private router:Router) { }

  login(user: User): Observable<Users> {
    return this.http.post<Users>(MAIN_URL + URL, user)
      .pipe(
        map((result)=>{
          this.users=result;

          if (this.users.user!=null){
            sessionStorage.setItem("user", JSON.stringify(this.users.user) );
            this.router.navigate(['/JobSeekerMain/dashboard']);
          }else if(this.users.jobPosterDTO!=null){
            sessionStorage.setItem("poster", JSON.stringify(this.users.jobPosterDTO) );
            this.router.navigate(['/JobPosterMain/dashboard']);
          }else {
            if (this.users.adminDTO!=null){
              sessionStorage.setItem("admin", JSON.stringify(this.users.adminDTO) );
              this.router.navigate(['/adminMain/dashboard']);
            }
          }
          return result;
        })
      )
  }



  logoutUser(): void{
    sessionStorage.removeItem("user");

  }

  logoutPoster(): void{
    sessionStorage.removeItem("poster");

  }

  logoutAdmin(): void{
    sessionStorage.removeItem("admin");

  }

  getUser(){
   return JSON.parse(sessionStorage.getItem("user"));
  }

  getJObPoster(){
    console.log(JSON.parse(sessionStorage.getItem("poster")))
    return JSON.parse(sessionStorage.getItem("poster"));
  }

  getAdmin(){
    return JSON.parse(sessionStorage.getItem("admin"));
  }

}

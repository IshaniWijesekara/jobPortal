import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Jobs} from "../dto/jobs";
import {Observable} from "rxjs/index";
import {MAIN_URL} from "./user-service.service";
import {PostJob} from "../dto/post-job";
import {JobPosterProfile} from "../dto/job-poster-profile";

const URLS="/api/v1/jobs"
const ImageURLS="/api/v1/jobs/file"

@Injectable()
export class JobsService {
  id:string;
  categoryName:string;
  postJob:PostJob=new PostJob;
  constructor(private http: HttpClient) {}

    addJob(postjob: PostJob): Observable<boolean> {
        return this.http.post<boolean>(MAIN_URL+URLS,postjob);
    }

  updateJob(postjob: PostJob): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL+URLS+"/update",postjob);
  }

    getPosterPostedJobs(username:string):Observable<Array<PostJob>>{
        return this.http.get<Array<PostJob>>(MAIN_URL+URLS+"/"+username);
    }

  saveFile(file:FormData): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + ImageURLS,file);
  }

  getFile(path : String): Observable<HttpEvent<{}>>{
    return this.http.get<HttpEvent<{}>>(MAIN_URL+URLS+"/file"+path);
  }

  getSelectedJobDetails(id : String): Observable<PostJob>{
    return this.http.get<PostJob>(MAIN_URL+URLS+"/search/"+id);
  }

  searchJobCategory(categoryName : String): Observable<Array<PostJob>>{
    return this.http.get<Array<PostJob>>(MAIN_URL+URLS+"/category/"+categoryName);
  }

  getTotalJobs():Observable<string>{
    return this.http.get<string>(MAIN_URL+URLS+"/Total")
  }

  getAllJobs():Observable<Array<PostJob>>{
    return this.http.get<Array<PostJob>>(MAIN_URL+URLS);
  }



  setId(id:string){
    this.id=id;
}
  getId(){
    return this.id;
  }

  setCategortName(categoryName:string){
    this.categoryName=categoryName;
  }
  getCategortName(){
    return this.categoryName;
  }

  setJobDetails(postjob:PostJob){
    this.postJob=postjob;
  }
  getJobDetails(){
    return this.postJob;
  }


}

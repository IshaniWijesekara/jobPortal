import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";
import {JObPosterService} from "../../service/job-poster.service";
import {JobPoster} from "../../dto/job-poster";
import {JobPosterProfile} from "../../dto/job-poster-profile";
import {Router} from "@angular/router";

@Component({
  selector: 'app-job-poster-main',
  templateUrl: './job-poster-main.component.html',
  styleUrls: ['./job-poster-main.component.css']
})
export class JobPosterMainComponent implements OnInit {

  jobposter:JobPoster=new JobPoster();
  jobPosterFrofile:JobPosterProfile=new JobPosterProfile();


  constructor(private authService:AuthService,private jobPosterProfileService:JobPosterProfileService,private jobposterService:JObPosterService,private router:Router) { }

  ngOnInit() {
    this.loadLoginedPoster();
    this.setUserDeatils();
  }

  logOut(): void{
    this.authService.logoutPoster();
    this.router.navigate(['/Main/Dashboard'])

  }

  loadLoginedPoster():void{
   this.jobposter=this.authService.getJObPoster();
  }

  setUserDeatils():void{
   this.jobPosterProfileService.searchJobPoster(this.jobposter.companyname).subscribe(
     (result)=>{
       this.jobPosterFrofile=result;
     }
   )
  }

  routeHome(){
    this.router.navigate(['/Main/Dashboard'])
  }

}

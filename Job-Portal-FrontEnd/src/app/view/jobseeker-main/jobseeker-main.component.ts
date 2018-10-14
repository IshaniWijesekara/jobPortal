import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../service/auth.service";
import {User} from "../../dto/user";
import {JobSeekerProfileService} from "../../service/job-seeker-profile.service";
import {JobSeekerProfile} from "../../dto/job-seeker-profile";

@Component({
  selector: 'app-jobseeker-main',
  templateUrl: './jobseeker-main.component.html',
  styleUrls: ['./jobseeker-main.component.css']
})
export class JobseekerMainComponent implements OnInit {

  user:User=new User();
  jobSeekerProfile:JobSeekerProfile=new JobSeekerProfile();
  constructor(private route:Router,private authService:AuthService,private jobSeekerProfileSevice:JobSeekerProfileService) { }

  ngOnInit() {
    this.getLoginedUser();
    this.searchJobSekkerDetails();
  }

  getLoginedUser(){
    this.user=this.authService.getUser();
    }

    searchJobSekkerDetails():void{
        this.jobSeekerProfileSevice.searchJobSeeker(this.user.username).subscribe(
          (result)=>{
            this.jobSeekerProfile=result;
          }
        )
    }
  routeHome():void{
    this.route.navigate(['/Main/Dashboard']);

  }

  logOut():void{
    this.authService.logoutUser();
    this.route.navigate(['/Main/Dashboard']);
  }
}

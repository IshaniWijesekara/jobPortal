import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {JobSeekerProfileService} from "../../service/job-seeker-profile.service";
import {User} from "../../dto/user";
import {JobSeekerProfile} from "../../dto/job-seeker-profile";

@Component({
  selector: 'app-jobseeker-dashboard',
  templateUrl: './jobseeker-dashboard.component.html',
  styleUrls: ['./jobseeker-dashboard.component.css']
})
export class JobseekerDashboardComponent implements OnInit {

  user:User=new User();
  jobSeekerProfile:JobSeekerProfile=new JobSeekerProfile();

  constructor(private authService:AuthService,private jobSeekerProfileSevice:JobSeekerProfileService) { }

  ngOnInit() {
    this.getLoginedUser();
    this.searchJobSeekerDetails()
  }

  getLoginedUser(){
    this.user=this.authService.getUser();
  }

  searchJobSeekerDetails():void{
    this.jobSeekerProfileSevice.searchJobSeeker(this.user.username).subscribe(
      (result)=>{
        this.jobSeekerProfile=result;
      }
    )
  }

}

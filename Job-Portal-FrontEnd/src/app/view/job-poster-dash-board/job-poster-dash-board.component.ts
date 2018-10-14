import { Component, OnInit } from '@angular/core';
import {JobsService} from "../../service/jobs.service";
import {JobPoster} from "../../dto/job-poster";
import {JobPosterProfile} from "../../dto/job-poster-profile";
import {AuthService} from "../../service/auth.service";
import {JobSeekerProfileService} from "../../service/job-seeker-profile.service";
import {JobPosterProfileService} from "../../service/job-poster-profile.service";

@Component({
  selector: 'app-job-poster-dash-board',
  templateUrl: './job-poster-dash-board.component.html',
  styleUrls: ['./job-poster-dash-board.component.css']
})
export class JobPosterDashBoardComponent implements OnInit {

  totalJobs:string;

  jobposter:JobPoster=new JobPoster();
  jobPosterFrofile:JobPosterProfile=new JobPosterProfile();

  constructor(private jobService:JobsService,private authService:AuthService,private jobPosterProfileService:JobPosterProfileService) { }

  ngOnInit() {
    this.getTotalJobs();
    this.loadLoginedPoster();
    this.setUserDeatils();
  }

  getTotalJobs():void{
    console.log("hello helloo hello")
    this.jobService.getTotalJobs().subscribe(
      (result)=>{
        this.totalJobs=result;
        console.log("job Total"+this.totalJobs)
      }
    )
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

}

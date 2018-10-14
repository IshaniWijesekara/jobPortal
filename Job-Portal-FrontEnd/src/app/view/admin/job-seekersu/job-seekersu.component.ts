import { Component, OnInit } from '@angular/core';
import {JobSeekerProfile} from "../../../dto/job-seeker-profile";
import {JobSeekerProfileService} from "../../../service/job-seeker-profile.service";

@Component({
  selector: 'app-job-seekersu',
  templateUrl: './job-seekersu.component.html',
  styleUrls: ['./job-seekersu.component.css']
})
export class JobSeekersuComponent implements OnInit {

  jobSeeker:Array<JobSeekerProfile>=[];
  constructor(private jobSeekerService:JobSeekerProfileService) { }

  ngOnInit() {
    this.getAllSeekers();
  }

  getAllSeekers():void{
    this.jobSeekerService.getAllSeekers().subscribe(
      (result)=>{
        this.jobSeeker=result;
      }
    )
  }
}

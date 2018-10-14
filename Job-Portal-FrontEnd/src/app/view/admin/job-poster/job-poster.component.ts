import { Component, OnInit } from '@angular/core';
import {JObPosterService} from "../../../service/job-poster.service";
import {JobPosterProfileService} from "../../../service/job-poster-profile.service";
import {JobPoster} from "../../../dto/job-poster";
import {JobPosterProfile} from "../../../dto/job-poster-profile";

@Component({
  selector: 'app-job-poster',
  templateUrl: './job-poster.component.html',
  styleUrls: ['./job-poster.component.css']
})
export class JobPosterComponent implements OnInit {

  JobPoster:Array<JobPosterProfile>=[];
  constructor(private jobPosterService:JobPosterProfileService) { }

  ngOnInit() {
    this.getAllJobPosters();
  }

  getAllJobPosters():void{
    this.jobPosterService.getAllPosters().subscribe(
      (result)=>{
        this.JobPoster=result;
      }
    )
  }
}

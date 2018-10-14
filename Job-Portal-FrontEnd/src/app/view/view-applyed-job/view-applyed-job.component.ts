import { Component, OnInit } from '@angular/core';
import {ApplyJobMain} from "../../dto/apply-job-main";
import {ApplyJobService} from "../../service/apply-job.service";
import {AuthService} from "../../service/auth.service";
import {JobPoster} from "../../dto/job-poster";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-applyed-job',
  templateUrl: './view-applyed-job.component.html',
  styleUrls: ['./view-applyed-job.component.css']
})
export class ViewApplyedJobComponent implements OnInit {

  applyedJob:ApplyJobMain=new ApplyJobMain();
  jobPOster:JobPoster=new JobPoster();
  applyedJobList:Array<ApplyJobMain>=[];
  constructor(private authService:AuthService,private applyJobService:ApplyJobService,private route:Router) { }

  ngOnInit() {
    this.getLoginedPoster();
    this.getAllApplyedJob();
  }

  getLoginedPoster():void{
    this.jobPOster=this.authService.getJObPoster();
  }
  getAllApplyedJob():void{
    this.applyJobService.getApplyedJobDetails(this.jobPOster.username).subscribe(
      (result)=>{
        this.applyedJobList=result;
      }
    )
  }

  searcSelectJob(id:number):void{
    this.applyJobService.searchJob(id).subscribe(
      (result)=>{
        if (result){
          this.applyedJob=result;
          this.applyJobService.setSelectedJob(this.applyedJob);
          this.route.navigate(['/JobPosterMain/ApplyedJobSeekerDetails'])
        }
      }
    )
  }
}

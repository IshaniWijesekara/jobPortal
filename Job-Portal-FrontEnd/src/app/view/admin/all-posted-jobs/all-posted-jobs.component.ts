import { Component, OnInit } from '@angular/core';
import {PostJob} from "../../../dto/post-job";
import {JobsService} from "../../../service/jobs.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-all-posted-jobs',
  templateUrl: './all-posted-jobs.component.html',
  styleUrls: ['./all-posted-jobs.component.css']
})
export class AllPostedJobsComponent implements OnInit {
  allPostedJobs:Array<PostJob>=[];
  constructor(private jobService:JobsService,private router:Router) { }

  ngOnInit() {
    this.getAllPostedJobs();
  }

  getAllPostedJobs():void{
    this.jobService.getAllJobs().subscribe(
      (result)=>{
        if(result){
          this.allPostedJobs=result;
        }
      }
    )
  }
  setSelectedJob(id:string):void{
    this.jobService.setId(id);
    this.router.navigate(['/adminMain/SelecteJob'])
  }
}

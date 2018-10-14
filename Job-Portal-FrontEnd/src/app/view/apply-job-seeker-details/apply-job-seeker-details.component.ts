import { Component, OnInit } from '@angular/core';
import {ApplyJobService} from "../../service/apply-job.service";
import {ApplyJobMain} from "../../dto/apply-job-main";
import {JobSeekerProfileService} from "../../service/job-seeker-profile.service";

@Component({
  selector: 'app-apply-job-seeker-details',
  templateUrl: './apply-job-seeker-details.component.html',
  styleUrls: ['./apply-job-seeker-details.component.css']
})
export class ApplyJobSeekerDetailsComponent implements OnInit {

  applyJob:ApplyJobMain=new ApplyJobMain();
  constructor(private applyJobService:ApplyJobService,private jobSeekerService:JobSeekerProfileService) { }

  ngOnInit() {
    this.getSelectedJob();
  }

  getSelectedJob():void{
    this.applyJob=this.applyJobService.getapplyedJob();
  }

  downloadFile():void{

    const formdata:FormData=new FormData();
    formdata.append("file",this.applyJob.applyJobDTO.jobSeeker.cvPath)
    this.jobSeekerService.downloadFile(formdata).subscribe(
      (result)=>{
        if(result){

        }
      }
    )
  }
}

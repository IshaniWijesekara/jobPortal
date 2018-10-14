import { Component, OnInit } from '@angular/core';
import {ApplyJobService} from "../../service/apply-job.service";
import {ApplyJobMain} from "../../dto/apply-job-main";
import {AuthService} from "../../service/auth.service";
import {User} from "../../dto/user";

@Component({
  selector: 'app-jobseeker-applyed-job',
  templateUrl: './jobseeker-applyed-job.component.html',
  styleUrls: ['./jobseeker-applyed-job.component.css']
})
export class JobseekerApplyedJobComponent implements OnInit {

  applyJobList:ApplyJobMain=new ApplyJobMain();
  user:User=new User();

  constructor(private authService:AuthService,private applyJobService:ApplyJobService) { }

  ngOnInit() {
    this.getLoginedSeeker();
    this.getSeekerApplyJobs();
  }

  getLoginedSeeker():void{
    this.user=this.authService.getUser();
  }


  getSeekerApplyJobs():void{
    this.applyJobService.getJobSeekerApplyedJob(this.user.username).subscribe(
      (result)=>{
        this.applyJobList=result;
      }
    )
  }
}

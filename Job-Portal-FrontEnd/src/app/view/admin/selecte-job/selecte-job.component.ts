import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/auth.service";
import {Router} from "@angular/router";
import {JobsService} from "../../../service/jobs.service";
import {PostJob} from "../../../dto/post-job";
import {User} from "../../../dto/user";
import {QulificationService} from "../../../service/qulification.service";

@Component({
  selector: 'app-selecte-job',
  templateUrl: './selecte-job.component.html',
  styleUrls: ['./selecte-job.component.css']
})
export class SelecteJobComponent implements OnInit {

  disable:boolean=false;
  user:User=new User();
  postjob:PostJob=new PostJob();
  constructor(private jobService:JobsService,private router:Router,private authService:AuthService,private qulificationService:QulificationService) { }

  ngOnInit() {
    this.getSelectedJobDetails();
  }

  getSelectedJobDetails(){

    var id=this.jobService.getId();
    this.jobService.getSelectedJobDetails(id).subscribe(
      (result)=>{
        if(result){
          this.postjob=result;
        }
      }
    )
  }


}

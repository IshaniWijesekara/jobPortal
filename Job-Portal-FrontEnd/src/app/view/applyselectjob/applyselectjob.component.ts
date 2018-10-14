import { Component, OnInit } from '@angular/core';
import {JobsService} from "../../service/jobs.service";
import {PostJob} from "../../dto/post-job";
import {Router} from "@angular/router";
import {User} from "../../dto/user";
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-applyselectjob',
  templateUrl: './applyselectjob.component.html',
  styleUrls: ['./applyselectjob.component.css']
})
export class ApplyselectjobComponent implements OnInit {

  disable:boolean=false;
  user:User=new User();
  postjob:PostJob=new PostJob();
  constructor(private jobService:JobsService,private router:Router,private authService:AuthService) { }

  ngOnInit() {
    this.getLoginedUser();
    this.getSelectedJobDetails();
  }

  getLoginedUser():void{
    this.user=this.authService.getUser();
    if (this.user!=null){
      this.disable=true;
    }else if (this.user==null){
      if(confirm("You Have To Login")){
        this.router.navigate(['/Main/login'])
      }else{
        this.router.navigate(['/Main/Dashboard'])
      }
    }
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

  setPostJob():void{
    this.jobService.setJobDetails(this.postjob);
    this.router.navigate(['/Main/ApplyJob']);
  }

}

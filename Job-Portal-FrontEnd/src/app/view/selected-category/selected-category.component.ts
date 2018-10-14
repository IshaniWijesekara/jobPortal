import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {PostJob} from "../../dto/post-job";
import {JobsService} from "../../service/jobs.service";

@Component({
  selector: 'app-selected-category',
  templateUrl: './selected-category.component.html',
  styleUrls: ['./selected-category.component.css']
})
export class SelectedCategoryComponent implements OnInit {

  id:string;
  categoryName:string;
  allPostedJobs:Array<PostJob>=[];
  constructor(private jobService:JobsService,private router:Router) { }

  ngOnInit() {
    this.getSelectedJob();
    this.getCategoryJobs();
  }

  getCategoryJobs():void{
    this.jobService.searchJobCategory(this.categoryName).subscribe(
      (result)=>{
        this.allPostedJobs=result
      }
    )
  }

  getSelectedJob():void {
    this.categoryName=this.jobService.getCategortName();


  }

  setSelectedJob(id:string):void {
    this.id=id;
     this.jobService.setId(id) ;
     this.router.navigate(['/Main/SelectedJob']);

  }
}

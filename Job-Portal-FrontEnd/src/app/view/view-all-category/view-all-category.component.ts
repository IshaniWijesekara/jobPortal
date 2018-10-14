import { Component, OnInit } from '@angular/core';
import {CategoryService} from "../../service/category.service";
import {Category} from "../../dto/category";
import {JobseekerApplyedJobComponent} from "../jobseeker-applyed-job/jobseeker-applyed-job.component";
import {JobsService} from "../../service/jobs.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-all-category',
  templateUrl: './view-all-category.component.html',
  styleUrls: ['./view-all-category.component.css']
})
export class ViewAllCategoryComponent implements OnInit {

  allCategory:Array<Category>=[];
  constructor(private categorySevice:CategoryService,private jobService:JobsService,private router:Router) {
    this.getAllCategory();
  }

  ngOnInit() {
    this.getAllCategory();
  }

  getAllCategory():void{
    console.log("Work")
    this.categorySevice.getAllCategory().subscribe(
      (result)=>{
        console.log("result"+result)
        this.allCategory=result;
      }
    )
  }

  setCategory(category:string):void{
    alert(category)
      this.jobService.setCategortName(category);
      this.router.navigate(['/Main/SelectJobCategory']);
  }

}

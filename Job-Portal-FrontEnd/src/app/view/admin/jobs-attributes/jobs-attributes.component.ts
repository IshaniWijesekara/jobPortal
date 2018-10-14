import { Component, OnInit } from '@angular/core';
import {Category} from "../../../dto/category";
import {CategoryService} from "../../../service/category.service";
import {BussinessFuntionService} from "../../../service/bussiness-funtion.service";
import {BussinessFuntion} from "../../../dto/bussiness-funtion";
import {Industry} from "../../../dto/industry";
import {IndustryService} from "../../../service/industry.service";
import {EducationalSpecializationService} from "../../../service/educational-specialization.service";
import {EducationalSpecialization} from "../../../dto/educational-specialization";

@Component({
  selector: 'app-jobs-attributes',
  templateUrl: './jobs-attributes.component.html',
  styleUrls: ['./jobs-attributes.component.css']
})
export class JobsAttributesComponent implements OnInit {

  category:Category=new Category();
  bussinessFuntion:BussinessFuntion=new BussinessFuntion();
  industry:Industry=new Industry();
  educationalSpecialization:EducationalSpecialization=new EducationalSpecialization();
  constructor(private categoryService:CategoryService,private bussinessFuntionService:BussinessFuntionService,private industryService:IndustryService,private educationalSpecializationService:EducationalSpecializationService) { }

  ngOnInit() {
  }

  addCategory():void{
    this.categoryService.addCategory(this.category).subscribe(
      (result)=>{
        if(result){
          alert("Sucsess")
        }else {
          alert("Failed")
        }
      }
    )
  }

  addBussinessFuntion():void{
    this.bussinessFuntionService.addBussinessFuntion(this.bussinessFuntion).subscribe(
      (result)=>{
        if(result){
          alert("Sucsess")
        }else {
          alert("Failed")
        }
      }
    )
  }

  addIndustry():void{
    console.log(this.industry)
    this.industryService.saveIndustry(this.industry).subscribe(
      (result)=>{
        if(result){
          alert("Sucsess")
        }else {
          alert("Failed")
        }

      }
    )
  }

  addEducationalSpecialization():void{
    this.educationalSpecializationService.saveEducationalSpecialization(this.educationalSpecialization).subscribe(
      (result)=>{
        if(result){
          alert("Sucsess")
        }else {
          alert("Failed")
        }
      }
    )
  }
}

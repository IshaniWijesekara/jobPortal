///<reference path="../../service/jobs.service.ts"/>
import {Component, ElementRef, OnInit} from '@angular/core';
import {Jobs} from "../../dto/jobs";
import {JobsService} from "../../service/jobs.service";
import {JobPoster} from "../../dto/job-poster";
import {JObPosterService} from "../../service/job-poster.service";
import {Qulification} from "../../dto/qulification";
import {PostJob} from "../../dto/post-job";
import {AuthService} from "../../service/auth.service";
import {CategoryService} from "../../service/category.service";
import {Category} from "../../dto/category";
import {EducationalSpecialization} from "../../dto/educational-specialization";
import {EducationalSpecializationService} from "../../service/educational-specialization.service";
import {IndustryService} from "../../service/industry.service";
import {Industry} from "../../dto/industry";
import {BussinessFuntionService} from "../../service/bussiness-funtion.service";
import {BussinessFuntion} from "../../dto/bussiness-funtion";

@Component({
  selector: 'app-postjob',
  templateUrl: './postjob.component.html',
  styleUrls: ['./postjob.component.css']
})
export class PostjobComponent implements OnInit {

  jobs:Jobs=new Jobs();
  qulifucation:Qulification=new Qulification();
  imageFile:File;
  setImageFileName:String="";
  jobPoster:JobPoster;
  requiredupdate:boolean=true;
  postJob:PostJob=new PostJob();
  categoryList:Array<Category>=[];
  industryList:Array<Industry>=[];
  bussinessFuntionList:Array<BussinessFuntion>=[];
  educationalSpecializationList:Array<EducationalSpecialization>=[];




  constructor(private authService:AuthService,private jobService:JobsService,private  jobposterService:JObPosterService,private elem:ElementRef,private categoryService:CategoryService,private educationalSpecializationService:EducationalSpecializationService,private industryService:IndustryService,private bussinesFuntionService:BussinessFuntionService) { }

  ngOnInit() {
    this.loadLoginedPoster();
    this.getAllCategory();
    this.getAllEducationalSpecialization();
    this.getAllIndustry();
    this.getAllBussinessFuntion();
  }



    addJOb():void{
    console.log("Sucsess")
    let industry=this.elem.nativeElement.querySelector('#industry').value;
    let category=this.elem.nativeElement.querySelector('#category').value;
    let bussinessfuntion=this.elem.nativeElement.querySelector('#bussinessfuntion').value;

    console.log(industry)
    this.jobs.industry=industry;
    this.jobs.category=category;
    this.jobs.bussinessfuntion=bussinessfuntion;

    let minimumqulification=this.elem.nativeElement.querySelector('#minimumqulification').value;
    let requiredexperience=this.elem.nativeElement.querySelector('#requiredexperience').value;
    let educationalspecialization=this.elem.nativeElement.querySelector('#educationalspecialization').value;
    let skill=this.elem.nativeElement.querySelector('#skill').value;
    let genderpreference=this.elem.nativeElement.querySelector('#genderpreference').value;
    let maimumage=this.elem.nativeElement.querySelector('#maimumage').value;

    console.log(minimumqulification)
    this.qulifucation.minimumqulification=minimumqulification;
    this.qulifucation.requiredexperience=requiredexperience;
    this.qulifucation.educationalspecialization=educationalspecialization;
    this.qulifucation.skill=skill;
    this.qulifucation.genderpreference=genderpreference;
    this.qulifucation.maximumage=maimumage;


    this.jobs.jobPosterDTO=this.jobPoster;
    this.postJob.jobsDTO=this.jobs;
    this.postJob.qulificationDTO=this.qulifucation;
    console.log(this.postJob)
      const formData:FormData=new FormData();
      formData.append("file",this.imageFile);
      console.log(this.imageFile)
      this.jobService.saveFile(formData).subscribe(
        (result)=>{
            if(result){
              this.jobService.addJob(this.postJob).subscribe(
                (result)=>{
                  if(result){
                    confirm("New Job Added successfully")
                  }else{
                    confirm("Fail to Add Re-Try")
                  }
                }
              )
            }
        }
      )


  }

  loadLoginedPoster():void{
    this.jobPoster=this.authService.getJObPoster();
    console.log(this.jobPoster)
  }

  saveFile():void {
    const formData:FormData=new FormData();
    formData.append("file",this.imageFile);
    console.log(this.imageFile)
    this.jobService.saveFile(formData).subscribe(
      (result)=>{

      }
    )
  }


  setIma(event) {
    console.log("fjjhjjh")
    const fil = event.target.files[0]

    this.imageFile = fil;

    console.log(this.imageFile)
  }

  getAllCategory():void{
    this.categoryService.getAllCategory().subscribe(
      (result)=>{
        this.categoryList=result;
      }
    )
  }

  getAllEducationalSpecialization():void{
    this.educationalSpecializationService.getAllEducationalSpecialization().subscribe(
      (result)=>{
        this.educationalSpecializationList=result;
      }
    )
  }

  getAllIndustry():void{
    this.industryService.getAllIndustry().subscribe(
      (result)=>{
        this.industryList=result;
      }
    )
  }

  getAllBussinessFuntion():void{
    this.bussinesFuntionService.getAllBussinessFuntion().subscribe(
      (result)=>{
        this.bussinessFuntionList=result;
      }
    )
  }
}

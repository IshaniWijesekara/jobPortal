import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../service/auth.service";
import {Admin} from "../../../dto/admin";
import {AdminProfile} from "../../../dto/admin-profile";
import {AdminService} from "../../../service/admin.service";

@Component({
  selector: 'app-admin-profile-manage',
  templateUrl: './admin-profile-manage.component.html',
  styleUrls: ['./admin-profile-manage.component.css']
})
export class AdminProfileManageComponent implements OnInit {

  adminProfile:AdminProfile=new AdminProfile();
  admin:Admin=new Admin();
  file:File;
  constructor(private authService:AuthService,private adminService:AdminService) { }

  ngOnInit() {
    this.getAdmin();
  }

  getAdmin(){
   this.admin=this.authService.getAdmin();
  }

  setImage(event):void{
    this.file=event.target.files[0];
  }

  saveProfileData(){
    this.adminProfile.admin=this.admin;
    const formdata:FormData=new FormData();
    formdata.append("file",this.file)
    this.adminService.uploadFile(formdata).subscribe(
      (result)=>{
        if (result){
          this.adminService.saveAdminProfile(this.adminProfile).subscribe(
            (result)=>{
              if(result){
                alert("Successfully Update Profile")
              }else {
                alert("Failed Update Profile")
              }
            }
          )
        }
      }
    )
  }
}

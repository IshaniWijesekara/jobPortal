import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './view/dashboard/dashboard.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import { LoginComponent } from './view/login/login.component';
import { MainComponent } from './view/main/main.component';
import { RegistationComponent } from './view/registation/registation.component';
import { ApplyComponent } from './view/apply/apply.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {UserServiceService} from './service/user-service.service';
import {AuthService} from './service/auth.service';
import { PosterRegistationComponent } from './view/poster-registation/poster-registation.component';
import {JObPosterService} from './service/job-poster.service';
import { SelectRegistationComponent } from './view/select-registation/select-registation.component';
import { JobPosterDashBoardComponent } from './view/job-poster-dash-board/job-poster-dash-board.component';
import { JobPosterMainComponent } from './view/job-poster-main/job-poster-main.component';
import { ManageprofileComponent } from './view/manageprofile/manageprofile.component';
import { PostjobComponent } from './view/postjob/postjob.component';
import { ViewpostedjobsComponent } from './view/viewpostedjobs/viewpostedjobs.component';
import {JobPosterProfileService} from './service/job-poster-profile.service';
import {JobsService} from './service/jobs.service';
import { PosterJobDetailsComponent } from './view/poster-job-details/poster-job-details.component';
import {QulificationService} from './service/qulification.service';
import { ViewallPostedJobsComponent } from './view/viewall-posted-jobs/viewall-posted-jobs.component';
import { ApplyselectjobComponent } from './view/applyselectjob/applyselectjob.component';
import { JobseekerMainComponent } from './view/jobseeker-main/jobseeker-main.component';
import { JobseekerDashboardComponent } from './view/jobseeker-dashboard/jobseeker-dashboard.component';
import { JobseekerManageProfileComponent } from './view/jobseeker-manage-profile/jobseeker-manage-profile.component';
import {JobSeekerProfileService} from './service/job-seeker-profile.service';
import {ApplyJobService} from './service/apply-job.service';
import { ViewApplyedJobComponent } from './view/view-applyed-job/view-applyed-job.component';
import { ApplyJobSeekerDetailsComponent } from './view/apply-job-seeker-details/apply-job-seeker-details.component';
import { JobseekerApplyedJobComponent } from './view/jobseeker-applyed-job/jobseeker-applyed-job.component';
import { AdminDashboardComponent } from './view/admin/admin-dashboard/admin-dashboard.component';
import { AdminMainComponent } from './view/admin/admin-main/admin-main.component';
import { JobsAttributesComponent } from './view/admin/jobs-attributes/jobs-attributes.component';
import { JobSeekersuComponent } from './view/admin/job-seekersu/job-seekersu.component';
import { JobPosterComponent } from './view/admin/job-poster/job-poster.component';
import { AdminProfileManageComponent } from './view/admin/admin-profile-manage/admin-profile-manage.component';
import {AdminService} from './service/admin.service';
import {CategoryService} from './service/category.service';
import {BussinessFuntionService} from './service/bussiness-funtion.service';
import {EducationalSpecializationService} from './service/educational-specialization.service';
import {IndustryService} from './service/industry.service';
import { AllPostedJobsComponent } from './view/admin/all-posted-jobs/all-posted-jobs.component';
import { SelecteJobComponent } from './view/admin/selecte-job/selecte-job.component';
import { ViewAllCategoryComponent } from './view/view-all-category/view-all-category.component';
import { SelectedCategoryComponent } from './view/selected-category/selected-category.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    MainComponent,
    RegistationComponent,
    ApplyComponent,
    PosterRegistationComponent,
    SelectRegistationComponent,
    JobPosterDashBoardComponent,
    JobPosterMainComponent,
    ManageprofileComponent,
    PostjobComponent,
    ViewpostedjobsComponent,
    PosterJobDetailsComponent,
    ViewallPostedJobsComponent,
    ApplyselectjobComponent,
    JobseekerMainComponent,
    JobseekerDashboardComponent,
    JobseekerManageProfileComponent,
    ViewApplyedJobComponent,
    ApplyJobSeekerDetailsComponent,
    JobseekerApplyedJobComponent,
    AdminDashboardComponent,
    AdminMainComponent,
    JobsAttributesComponent,
    JobSeekersuComponent,
    JobPosterComponent,
    AdminProfileManageComponent,
    AllPostedJobsComponent,
    SelecteJobComponent,
    ViewAllCategoryComponent,
    SelectedCategoryComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    UserServiceService,
    JObPosterService,
    JobPosterProfileService,
    JobsService,
    QulificationService,
    JobSeekerProfileService,
    ApplyJobService,
    AdminService,
    CategoryService,
    BussinessFuntionService,
    EducationalSpecializationService,
    IndustryService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

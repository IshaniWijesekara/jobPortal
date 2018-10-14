import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardComponent} from '../view/dashboard/dashboard.component';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from '../view/login/login.component';
import {MainComponent} from '../view/main/main.component';
import {RegistationComponent} from '../view/registation/registation.component';
import {SelectRegistationComponent} from '../view/select-registation/select-registation.component';
import {PosterRegistationComponent} from '../view/poster-registation/poster-registation.component';
import {JobPosterDashBoardComponent} from '../view/job-poster-dash-board/job-poster-dash-board.component';
import {JobPosterMainComponent} from '../view/job-poster-main/job-poster-main.component';
import {ManageprofileComponent} from '../view/manageprofile/manageprofile.component';
import {PostjobComponent} from '../view/postjob/postjob.component';
import {ViewpostedjobsComponent} from '../view/viewpostedjobs/viewpostedjobs.component';
import {PosterJobDetailsComponent} from '../view/poster-job-details/poster-job-details.component';
import {ViewallPostedJobsComponent} from '../view/viewall-posted-jobs/viewall-posted-jobs.component';
import {ApplyselectjobComponent} from '../view/applyselectjob/applyselectjob.component';
import {JobseekerDashboardComponent} from '../view/jobseeker-dashboard/jobseeker-dashboard.component';
import {JobseekerMainComponent} from '../view/jobseeker-main/jobseeker-main.component';
import {JobseekerManageProfileComponent} from '../view/jobseeker-manage-profile/jobseeker-manage-profile.component';
import {ApplyComponent} from '../view/apply/apply.component';
import {ViewApplyedJobComponent} from '../view/view-applyed-job/view-applyed-job.component';
import {ApplyJobSeekerDetailsComponent} from '../view/apply-job-seeker-details/apply-job-seeker-details.component';
import {JobseekerApplyedJobComponent} from '../view/jobseeker-applyed-job/jobseeker-applyed-job.component';
import {AdminMainComponent} from '../view/admin/admin-main/admin-main.component';
import {AdminDashboardComponent} from '../view/admin/admin-dashboard/admin-dashboard.component';
import {AdminProfileManageComponent} from '../view/admin/admin-profile-manage/admin-profile-manage.component';
import {JobsAttributesComponent} from '../view/admin/jobs-attributes/jobs-attributes.component';
import {AllPostedJobsComponent} from '../view/admin/all-posted-jobs/all-posted-jobs.component';
import {SelecteJobComponent} from '../view/admin/selecte-job/selecte-job.component';
import {ViewAllCategoryComponent} from '../view/view-all-category/view-all-category.component';
import {SelectedCategoryComponent} from '../view/selected-category/selected-category.component';
import {JobPosterComponent} from '../view/admin/job-poster/job-poster.component';
import {JobSeekersuComponent} from '../view/admin/job-seekersu/job-seekersu.component';

const routes: Routes = [
  {path : 'Main', component: MainComponent,
    children: [
      {path: 'Dashboard', component: DashboardComponent,
      children: [
        {
          path: 'ViewAllJobs',
          pathMatch : 'full',
          redirectTo: '/Main/ViewAllJobs'
        },
        {
          path: 'ViewAllCategory',
          pathMatch : 'full',
          redirectTo: '/Main/viewAllCategory'
        },
      ]},
      {
        path: 'SelectRegistation',
        component: SelectRegistationComponent,
        children: [
          {
            path: 'LoginRegister',
            pathMatch : 'full',
            redirectTo: '/Main/registation'
          },
          {
            path: 'JobPosterRegister',
            pathMatch : 'full',
            redirectTo: '/Main/JobPosterRegistation'
          },
        ]},


      {
        path: 'login',
        component: LoginComponent,
      children: [
        {
          path: 'LoginRegister',
          pathMatch : 'full',
          redirectTo: '/Main/SelectRegistation'
        },




      ]},



      {
        path: 'registation',
        component: RegistationComponent},

      {
        path: 'ViewAllJobs',
        component: ViewallPostedJobsComponent,
        children: [
          {
            path: 'SelectedJob',
            pathMatch: 'full',
            redirectTo: '/Main/SelectedJob'
          },
      ]},
      {path: 'viewAllCategory', component: ViewAllCategoryComponent},
      {path: 'SelectJobCategory', component: SelectedCategoryComponent},
      {
        path: 'JobPosterRegistation',
        component: PosterRegistationComponent},

      {
        path: 'SelectedJob',
        component: ApplyselectjobComponent,
        children: [
          {
            path: 'ApplyJob',
            pathMatch: 'full',
            redirectTo: '/Main/ApplyJob'
          },
        ]},

      {
        path: 'ApplyJob',
        component: ApplyComponent},
      {
        path: '',
        pathMatch : 'full',
        redirectTo: '/Main/Dashboard'
      }
    ]
  },
  {path : '', redirectTo:  '/Main/Dashboard', pathMatch : 'full' },

  {
    path: 'JobPosterMain',
    component: JobPosterMainComponent,
    children: [
      {path: 'dashboard', component: JobPosterDashBoardComponent},
      {path: 'ViewApplyJob', component: ViewApplyedJobComponent,
      children: [
        {
          path: 'ViewApplyedPosterDetails',
          pathMatch : 'full',
          redirectTo: '/JobPosterMain/ApplyedJobSeekerDetails'
        }
      ]},

      {
        path: 'ManagePosterProfile',
        component: ManageprofileComponent
      },
      {
        path: 'jobDetails',
        component: PosterJobDetailsComponent
      },

      {
        path: 'ViewPostJobs',
        component: ViewpostedjobsComponent,
        children: [
          {
            path: 'posterJobDetails',
            pathMatch : 'full',
            redirectTo: '/JobPosterMain/jobDetails'
          }
          ]},

      {
        path: 'PostJob',
        component: PostjobComponent
      },
      {
        path: 'ApplyedJobSeekerDetails',
        component: ApplyJobSeekerDetailsComponent
      },

      {
        path: 'jobDetails',
        component: PosterJobDetailsComponent
      },

      {
        path: '',
        pathMatch : 'full',
        redirectTo: '/JobPosterMain/dashboard'
      },

    ]
  },

  {path: '', pathMatch: 'full', redirectTo: '/JobPosterMain/dashboard'},

  {
    path: 'JobSeekerMain',
    component: JobseekerMainComponent,
    children: [
      {path: 'dashboard', component: JobseekerDashboardComponent},
      {path: 'ManageProfile', component: JobseekerManageProfileComponent},
      {path: 'seekerApplyJobs', component: JobseekerApplyedJobComponent},
      {
        path: '',
        pathMatch : 'full',
        redirectTo: '/JobSeekerMain/dashboard'
      },

    ]
  },


  {
    path: 'adminMain',
    component: AdminMainComponent,
    children: [
      {path: 'dashboard', component: AdminDashboardComponent},
      {path: 'manageProfile', component: AdminProfileManageComponent},
      {path: 'ManageJobsA', component: JobsAttributesComponent},
      {path: 'viewAllPostedJobs', component: AllPostedJobsComponent},
      {path: 'SelecteJob', component: SelecteJobComponent},
      {path: 'JobPoster', component: JobPosterComponent},
      {path: 'JobSeeker', component: JobSeekersuComponent},
      {
        path: '',
        pathMatch : 'full',
        redirectTo: '/adminMain/dashboard'
      },

    ]
  },

  {path: '', pathMatch: 'full', redirectTo: '/JobPosterMain/dashboard'}

];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }

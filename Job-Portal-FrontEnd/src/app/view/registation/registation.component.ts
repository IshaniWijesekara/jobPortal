import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {User} from '../../dto/user';
import {NgForm} from '@angular/forms';
import {UserServiceService} from '../../service/user-service.service';

@Component({
  selector: 'app-registation',
  templateUrl: './registation.component.html',
  styleUrls: ['./registation.component.css']
})
export class RegistationComponent implements OnInit {
  @ViewChild('frmRegistation') frmRegistation: NgForm;
  Cheakpassword = '';
  user: User = new User();

  constructor(private elem: ElementRef, private userService: UserServiceService) { }

  ngOnInit() {
  }

  RegisterUser(): void {

    const username = this.elem.nativeElement.querySelector('#username').value;
    const email = this.elem.nativeElement.querySelector('#email').value;
    const password = this.elem.nativeElement.querySelector('#password').value;
    const repassword = this.elem.nativeElement.querySelector('#repassword').value;
    if (password == repassword) {
        this.user.username = username;
        this.user.email = email;
        this.user.password = password;
          this.userService.addUser(this.user).subscribe(
            (result) => {
              if (result) {
                alert('Registation successfully');
              } else {
                alert('Registation Failed');
              }
            }

          );
    } else {
      this.Cheakpassword = 'Doesn\'t match passwords ';
    }
  }

}

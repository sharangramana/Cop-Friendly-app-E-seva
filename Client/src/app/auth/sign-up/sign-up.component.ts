import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {SignupRequestPayload} from './signup-request-payload'
import { AuthService } from '../shared/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signupRequestPayload: SignupRequestPayload;
  signupForm: FormGroup;

  constructor(private authService: AuthService) {
      this.signupRequestPayload = {
        "Police_Id" : 0,
        "Password" : "",
        "First_Name" : "",
        "Last_Name" : "",
        "Position_type":"",
        "Work_Area" : "",
        "Station_Name" : "",
        "Phone_Number" : "",
        "Blood_Group" : "",
        "Address" : ""
      }
  }

  ngOnInit() {
    this.signupForm = new FormGroup({
      policeId: new FormControl('', Validators.required),
      firstname: new FormControl('', Validators.required),
      lastname: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      positiontype: new FormControl('', Validators.required),
      workarea: new FormControl('', Validators.required),
      stationname: new FormControl('', Validators.required),
      phonenumber: new FormControl('', Validators.required),
      bloodgroup: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required)
      //email: new FormControl('', [Validators.required, Validators.email]),
      
    });
  }

  signup() {
    console.log(this.signupForm.value);
    this.signupRequestPayload.Police_Id = this.signupForm.get('policeId').value;
    this.signupRequestPayload.First_Name = this.signupForm.get('firstname').value;
    this.signupRequestPayload.Last_Name = this.signupForm.get('lastname').value;
    this.signupRequestPayload.Password = this.signupForm.get('password').value;
    this.signupRequestPayload.Position_type = this.signupForm.get('positiontype').value;
    this.signupRequestPayload.Work_Area = this.signupForm.get('workarea').value;
    this.signupRequestPayload.Station_Name = this.signupForm.get('stationname').value;
    this.signupRequestPayload.Phone_Number = this.signupForm.get('phonenumber').value;
    this.signupRequestPayload.Blood_Group = this.signupForm.get('bloodgroup').value;
    this.signupRequestPayload.Address = this.signupForm.get('address').value;

    this.authService.signup(this.signupRequestPayload).subscribe(() => {
      console.log('Signup Successful');
    }, () => {
      console.log('Signup Failed');
    });
  }

}

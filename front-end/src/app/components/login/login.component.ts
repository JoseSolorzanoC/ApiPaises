import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, Validators, FormGroup} from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  public newForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')})

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.newForm = this.formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]]})
  }

  hide = true;
  password = new FormControl('', [Validators.required]);
  email = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
}

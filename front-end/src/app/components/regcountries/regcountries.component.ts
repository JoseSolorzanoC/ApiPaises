import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-regcountries',
  templateUrl: './regcountries.component.html',
  styleUrls: ['./regcountries.component.sass']
})
export class RegcountriesComponent implements OnInit {

  public form!: FormGroup
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      country: ['', [Validators.required]],
      ename: ['', [Validators.required]],
      flag: ['', [Validators.required]],
      capital: ['', [Validators.required]],
      latitude: ['', [Validators.required]],
      longitude: ['', [Validators.required]],
      tld: ['', [Validators.required]],
      iso3: ['', [Validators.required]],
      iso2: ['', [Validators.required]],
      fips: ['', [Validators.required]],
      isoN: ['', [Validators.required]]
    });
  }

  send(): any{
    console.log(this.form.value);
  }

}

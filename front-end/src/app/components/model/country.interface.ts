import {CountryCodesI} from './countryCodes.interface';
export interface CountryI{
  name:string;
  englishName:string;
  flag:string;
  capital:string;
  latitude: number;
  longitude: number;
  statecountry: "1";
  countryCodes: {
    fips: string;
    iso2: string;
    iso3: string;
    ison: number;
    tld: string;
  },
	callCode: string[];
}
import {CountryCodesI} from './countryCodes.interface';
export interface CountryI{
  name:string;
  englishName:string;
  flag:string;
  capital:string;
  latitude: number;
  longitude: number;
  countryCodes: CountryCodesI[];
	callCode: string[];
}

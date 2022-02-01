export interface CountryCodeU{
  id: string;
  countryId: number;
  name:string;
  englishName:string;
  flag:string;
  capital:string;
  latitude: number;
  longitude: number;
  countryCodes: {
    fips: string;
    iso2: string;
    iso3: string;
    ison: number;
    tld: string;
  },
  statecountry: string;
	callCode: string[];
}

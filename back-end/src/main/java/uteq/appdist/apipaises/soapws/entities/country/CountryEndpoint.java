package uteq.appdist.apipaises.soapws.entities.country;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.country.Country;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountriesResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountryByIdRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://country.interfaces.generated.soapws.apipaises.appdist.uteq";

    private CountryService countryService;

    @Autowired
    public CountryEndpoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountriesRequest")
    @ResponsePayload
    public GetCountriesResponse getAllCountries() {
        GetCountriesResponse response = new GetCountriesResponse();

        for (uteq.appdist.apipaises.soapws.entities.country.Country source : countryService.getAllCountries()) {
            Country target = new Country();
            BeanUtils.copyProperties(source, target);

            response.getCountry().add(target);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByIdRequest")
    @ResponsePayload
    public GetCountryResponse getCountryById(@RequestPayload GetCountryByIdRequest request) {
        GetCountryResponse response = new GetCountryResponse();

        Country target = new Country();

        if (countryService.getCountryById(request.getCountryId()).isPresent()) {
            BeanUtils.copyProperties(countryService.getCountryById(request.getCountryId()).get(), target);
        } else {
            target = null;
        }

        response.setCountry(target);

        return response;
    }

}

package uteq.appdist.apipaises.soapws.entities.country;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.country.Country;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://country.interfaces.generated.soapws.apipaises.appdist.uteq";

    private CountryService countryService;

    @Autowired
    public CountryEndpoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getAllCountries() {
        GetCountryResponse response = new GetCountryResponse();

        for (uteq.appdist.apipaises.soapws.entities.country.Country source : countryService.getAllCountries()) {
            Country target = new Country();
            BeanUtils.copyProperties(source, target);

            response.getCountry().add(target);
        }

        return response;
    }
}

package uteq.appdist.apipaises.soapws.entities.country;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.country.AddCountryRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.AddCountryResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.Countries;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.Country;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetAllCountriesResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountryByIdRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountryByIdResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.ServiceStatus;

import uteq.appdist.apipaises.soapws.shared.ServiceResponse;

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
    public GetAllCountriesResponse getAllCountries() {
        GetAllCountriesResponse response = new GetAllCountriesResponse();
        response.setCountries(new Countries());

        for (uteq.appdist.apipaises.soapws.entities.country.Country source : countryService.getAllCountries()) {
            Country target = new Country();
            BeanUtils.copyProperties(source, target);

            response.getCountries().getCountry().add(target);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByIdRequest")
    @ResponsePayload
    public GetCountryByIdResponse getCountryById(@RequestPayload GetCountryByIdRequest request) {
        GetCountryByIdResponse response = new GetCountryByIdResponse();

        Country target = new Country();

        if (countryService.getCountryById(request.getCountryId()).isPresent()) {
            BeanUtils.copyProperties(countryService.getCountryById(request.getCountryId()).get(), target);
        } else {
            target = null;
        }

        response.setCountry(target);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCountryRequest")
    @ResponsePayload
    public AddCountryResponse saveCountry(@RequestPayload AddCountryRequest request) {
        AddCountryResponse response = new AddCountryResponse();
        ServiceResponse serviceResponse;
        request.getCountry().setCountryId(0);

        Country target = new Country();
        ServiceStatus serviceStatus = new ServiceStatus();

        uteq.appdist.apipaises.soapws.entities.country.Country countryLocalModel = new uteq.appdist.apipaises.soapws.entities.country.Country();
        BeanUtils.copyProperties(request.getCountry(), countryLocalModel);

        serviceResponse = countryService.saveCountry(countryLocalModel);

        if (serviceResponse.getStatus() == -1) {
            serviceStatus.setStatus("ERROR");
            target = null;
        } else {
            serviceStatus.setStatus("SUCCESS");
            countryLocalModel.setCountryId(serviceResponse.getIdentif());
            BeanUtils.copyProperties(countryLocalModel, target);
        }

        serviceStatus.setMessage(serviceResponse.getAdditionalMessage());

        response.setCountry(target);
        response.setServiceStatus(serviceStatus);

        return response;
    }
}

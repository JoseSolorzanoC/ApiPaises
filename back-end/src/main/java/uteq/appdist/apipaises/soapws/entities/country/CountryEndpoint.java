package uteq.appdist.apipaises.soapws.entities.country;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.country.AddCountryRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.AddCountryResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.Country;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountriesResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountryByIdRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.GetCountryResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.ServiceStatus;
import uteq.appdist.apipaises.soapws.shared.DBResponse;

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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCountryRequest")
    @ResponsePayload
    public AddCountryResponse saveCountry(@RequestPayload AddCountryRequest request) {
        AddCountryResponse response = new AddCountryResponse();
        request.getCountry().setCountryId(0);

        Country target = new Country();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            uteq.appdist.apipaises.soapws.entities.country.Country countryLocalModel = new uteq.appdist.apipaises.soapws.entities.country.Country();
            BeanUtils.copyProperties(request.getCountry(), countryLocalModel);

            DBResponse dbResponse;

            dbResponse = countryService.saveCountry(countryLocalModel);

            if (dbResponse.getStatus() == 4) {
                serviceStatus.setStatus("INCORRECTO");
                serviceStatus.setMessage("ERROR AL INSERTAR EL REGISTRO");
                target = null;
            } else {
                serviceStatus.setStatus("CORRECTO");
                serviceStatus.setMessage("REGISTRO INSERTADO SATISFACTORIAMENTE");
                BeanUtils.copyProperties(countryLocalModel, target);
            }
        } catch (Exception e) {
            serviceStatus.setStatus("INCORRECTO");
            serviceStatus.setMessage("ERROR AL INSERTAR EL REGISTRO");
            target = null;
        }

        response.setCountry(target);
        response.setServiceStatus(serviceStatus);

        return response;
    }

}

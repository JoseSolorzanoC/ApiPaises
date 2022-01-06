package uteq.appdist.apipaises.soapws.entities.city;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.city.AddCityRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.AddCityResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.Cities;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.City;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.GetCitiesByProvinceIdRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.GetCitiesByProvinceIdResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.GetCityByIdRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.GetCityByIdResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.ServiceStatus;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.UpdateCityRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.city.UpdateCityResponse;
import uteq.appdist.apipaises.soapws.shared.ServiceResponse;

@Endpoint
@CrossOrigin("*")
public class CityEndpoint {
    private static final String NAMESPACE_URI = "http://city.interfaces.generated.soapws.apipaises.appdist.uteq";

    private CityService cityService;

    @Autowired
    public CityEndpoint(CityService countryService) {
        this.cityService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCitiesByProvinceIdRequest")
    @ResponsePayload
    public GetCitiesByProvinceIdResponse getCitiesByProvinceId(@RequestPayload GetCitiesByProvinceIdRequest request) {
        GetCitiesByProvinceIdResponse response = new GetCitiesByProvinceIdResponse();
        response.setCities(new Cities());

        for (uteq.appdist.apipaises.soapws.entities.city.City source : cityService.getAllCitiesFromProvince(request.getProvinceId())) {
            City target = new City();
            BeanUtils.copyProperties(source, target);

            response.getCities().getCity().add(target);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCityByIdRequest")
    @ResponsePayload
    public GetCityByIdResponse getCountryById(@RequestPayload GetCityByIdRequest request) {
        GetCityByIdResponse response = new GetCityByIdResponse();

        City target = new City();

        if (cityService.getCityById(request.getCityId()).isPresent()) {
            BeanUtils.copyProperties(cityService.getCityById(request.getCityId()).get(), target);
        } else {
            target = null;
        }

        response.setCity(target);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCityRequest")
    @ResponsePayload
    public AddCityResponse saveCountry(@RequestPayload AddCityRequest request) {
        AddCityResponse response = new AddCityResponse();
        ServiceResponse serviceResponse;
        request.getCity().setCityId(0);

        City target = new City();
        ServiceStatus serviceStatus = new ServiceStatus();

        uteq.appdist.apipaises.soapws.entities.city.City cityLocalModel = new uteq.appdist.apipaises.soapws.entities.city.City();
        BeanUtils.copyProperties(request.getCity(), cityLocalModel);

        serviceResponse = cityService.saveCity(cityLocalModel);

        if (serviceResponse.getStatus() == -1) {
            serviceStatus.setStatus("ERROR");
            target = null;
        } else {
            serviceStatus.setStatus("SUCCESS");
            cityLocalModel.setCityId(serviceResponse.getIdentif());
            BeanUtils.copyProperties(cityLocalModel, target);
        }

        serviceStatus.setMessage(serviceResponse.getAdditionalMessage());

        response.setCity(target);
        response.setServiceStatus(serviceStatus);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCityRequest")
    @ResponsePayload
    public UpdateCityResponse updateCountry(@RequestPayload UpdateCityRequest request) {
        UpdateCityResponse response = new UpdateCityResponse();
        ServiceResponse serviceResponse;

        City target = new City();
        ServiceStatus serviceStatus = new ServiceStatus();

        uteq.appdist.apipaises.soapws.entities.city.City cityLocalModel = new uteq.appdist.apipaises.soapws.entities.city.City();
        BeanUtils.copyProperties(request.getCity(), cityLocalModel, getNullPropertyNames(request.getCity()));

        serviceResponse = cityService.updateCity(cityLocalModel);

        if (serviceResponse.getStatus() == -1) {
            serviceStatus.setStatus("ERROR");
            target = null;
        } else {
            serviceStatus.setStatus("SUCCESS");
            cityLocalModel.setCityId(serviceResponse.getIdentif());
            BeanUtils.copyProperties(cityLocalModel, target, getNullPropertyNames(request.getCity()));
        }

        serviceStatus.setMessage(serviceResponse.getAdditionalMessage());

        response.setCity(target);
        response.setServiceStatus(serviceStatus);

        return response;
    }

    // Para Copiar propiedades con valores nulos
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}

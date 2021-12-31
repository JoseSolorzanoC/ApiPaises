
package uteq.appdist.apipaises.soapws.entities.province;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.sym.Name;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.shared.DBResponse;
import uteq.appdist.apipaises.soapws.shared.ServiceResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.ServiceStatus;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.UpdateProvinceRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.UpdateProvinceResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.AddProvinceRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.AddProvinceResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.GetAllProvincesResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.GetCountryByIso2Request;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.GetProvinceByIdRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.ProvinceResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.Provinces;

@Endpoint
public class ProvinceEndpoint {
    private static final String NAMESPACE_URI = "http://province.interfaces.generated.soapws.apipaises.appdist.uteq";

    private ProvinceService provinceService;

    @Autowired
    public ProvinceEndpoint(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    //GET ALL PROVINCES
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProvincesRequest")
    @ResponsePayload
    public GetAllProvincesResponse getAllProvinces() {
        GetAllProvincesResponse response = new GetAllProvincesResponse();
        response.setProvinces(new Provinces());

        for (uteq.appdist.apipaises.soapws.entities.province.Province source : provinceService.getAllProvinces()) {
            ProvinceResponse target = new ProvinceResponse();
            BeanUtils.copyProperties(source, target,getNullPropertyNames(source));

            

            
            response.getProvinces().getProvince().add(target);
        }

        return response;
    }

    //GET ALL PROVINCE BY COUNTRY
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByIso2Request")
    @ResponsePayload
    public GetAllProvincesResponse getProvinceByCountry(@RequestPayload GetCountryByIso2Request request) {
        GetAllProvincesResponse response = new GetAllProvincesResponse();
        response.setProvinces(new Provinces());

        for (uteq.appdist.apipaises.soapws.entities.province.Province source : provinceService.getAllProvincesByCountry(request.getCountryIso2())) {
            ProvinceResponse target = new ProvinceResponse();
            BeanUtils.copyProperties(source, target,getNullPropertyNames(source));
            response.getProvinces().getProvince().add(target);
        }

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

@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addProvinceRequest")
@ResponsePayload
public AddProvinceResponse saveProvince(@RequestPayload AddProvinceRequest request) {
    AddProvinceResponse response = new AddProvinceResponse();
    ServiceResponse serviceResponse;
    request.getProvince();

    ProvinceResponse target = new ProvinceResponse();
    ServiceStatus serviceStatus = new ServiceStatus();

    uteq.appdist.apipaises.soapws.entities.province.Province provinceLocalModel = new uteq.appdist.apipaises.soapws.entities.province.Province();
    BeanUtils.copyProperties(request.getProvince(), provinceLocalModel);

    serviceResponse = provinceService.saveProvince(provinceLocalModel,request.getProvince().getIso2());

    if (serviceResponse.getStatus() == -1) {
        serviceStatus.setStatus("ERROR");
        target = null;
    } else {
        serviceStatus.setStatus("SUCCESS");
        provinceLocalModel.setProvinceId(serviceResponse.getIdentif());
        BeanUtils.copyProperties(provinceLocalModel, target);
    }

    serviceStatus.setMessage(serviceResponse.getAdditionalMessage());

    response.setProvince(target);
    response.setServiceStatus(serviceStatus);

    return response;
}

@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProvinceRequest")
@ResponsePayload
public UpdateProvinceResponse updateCountry(@RequestPayload UpdateProvinceRequest request) {
    UpdateProvinceResponse response = new UpdateProvinceResponse();
    ServiceResponse serviceResponse;
    request.getProvince();

    ProvinceResponse target = new ProvinceResponse();
    ServiceStatus serviceStatus = new ServiceStatus();

    uteq.appdist.apipaises.soapws.entities.province.Province provinceLocalModel = new uteq.appdist.apipaises.soapws.entities.province.Province();
    BeanUtils.copyProperties(request.getProvince(), provinceLocalModel);

    serviceResponse = provinceService.updateProvince(provinceLocalModel,request.getProvince().getIso2());

    if (serviceResponse.getStatus() == -1) {
        serviceStatus.setStatus("ERROR");
        target = null;
    } else {
        serviceStatus.setStatus("SUCCESS");
        provinceLocalModel.setProvinceId(serviceResponse.getIdentif());
        BeanUtils.copyProperties(provinceLocalModel, target);
    }

    serviceStatus.setMessage(serviceResponse.getAdditionalMessage());

    response.setProvince(target);
    response.setServiceStatus(serviceStatus);

    return response;
}

}

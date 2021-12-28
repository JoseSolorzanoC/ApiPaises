
package uteq.appdist.apipaises.soapws.entities.province;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.province.Province;
import uteq.appdist.apipaises.soapws.shared.DBResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.country.ServiceStatus;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.AddProvinceResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.GetProvinceByIdRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.GetProvinceResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.GetProvincesResponse;

@Endpoint
public class ProvinceEndpoint {
    private static final String NAMESPACE_URI = "http://province.interfaces.generated.soapws.apipaises.appdist.uteq";

    private ProvinceService provinceService;

    @Autowired
    public ProvinceEndpoint(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProvincesRequest")
    @ResponsePayload
    public GetProvincesResponse getAllProvinces() {
        GetProvincesResponse response = new GetProvincesResponse();

        for (uteq.appdist.apipaises.soapws.entities.province.Province source : provinceService.getAllProvinces()) {
            Province target = new Province();
            BeanUtils.copyProperties(source, target);

            response.getProvince().add(target);
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProvinceByIdRequest")
    @ResponsePayload
    public GetProvinceResponse getProvinceById(@RequestPayload GetProvinceByIdRequest request) {
        GetProvinceResponse response = new GetProvinceResponse();

        Province target= new Province();

        if(provinceService.getProvinceById(request.getProvinceId()).isPresent()){

            BeanUtils.copyProperties(provinceService.getProvinceById(request.getProvinceId()).get(), target);
  
        }

        return response;
    }


    // @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addProvinceRequest")
    // @ResponsePayload
    // public DBResponse addProvinceRequest(uteq.appdist.apipaises.soapws.entities.province.Province province) {
    //     DBResponse response = new DBResponse();

    //     response = provinceService.addProvince(province);

    //     return response;
    // }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editProvinceRequest")
    @ResponsePayload
    public DBResponse editProvinceRequest(uteq.appdist.apipaises.soapws.entities.province.Province province) {
        DBResponse response = new DBResponse();

        response = provinceService.editProvince(province);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "delProvinceRequest")
    @ResponsePayload
    public DBResponse delProvinceRequest(int provinceId) {
        DBResponse response = new DBResponse();

        response = provinceService.delProvince(provinceId);

        return response;
    }

}

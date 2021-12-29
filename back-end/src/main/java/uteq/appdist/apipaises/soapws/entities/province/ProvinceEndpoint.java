
package uteq.appdist.apipaises.soapws.entities.province;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.sym.Name;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.province.Province;
import uteq.appdist.apipaises.soapws.shared.DBResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.ServiceStatus;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.AddProvinceRequest;
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

        Province target = new Province();

        if (provinceService.getProvinceById(request.getProvinceId()).isPresent()) {

            BeanUtils.copyProperties(provinceService.getProvinceById(request.getProvinceId()).get(), target);

        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addProvinceRequest")
    @ResponsePayload
    public AddProvinceResponse saveCountry(@RequestPayload AddProvinceRequest request) {
        AddProvinceResponse response = new AddProvinceResponse();
        request.getProvince().setProvinceId(0);

        Province target = new Province();
        ServiceStatus serviceStatus = new ServiceStatus();

        try {
            uteq.appdist.apipaises.soapws.entities.province.Province provinceLocalModel = new uteq.appdist.apipaises.soapws.entities.province.Province();
            BeanUtils.copyProperties(request.getProvince(), provinceLocalModel);

            DBResponse dbResponse;

            dbResponse = provinceService.saveProvince(provinceLocalModel,"");

            if (dbResponse.getStatus() == 4) {
                serviceStatus.setStatus("INCORRECTO");
                serviceStatus.setMessage("ERROR AL INSERTAR EL REGISTRO");
                target = null;
            } else {
                serviceStatus.setStatus("CORRECTO");
                serviceStatus.setMessage("REGISTRO INSERTADO SATISFACTORIAMENTE");
                provinceLocalModel.setProvinceId(dbResponse.getIdentif());
                BeanUtils.copyProperties(provinceLocalModel, target);
            }
        } catch (Exception e) {
            serviceStatus.setStatus("INCORRECTO");
            serviceStatus.setMessage("ERROR AL INSERTAR EL REGISTRO");
            target = null;
        }

        response.setProvince(target);
        response.setServiceStatus(serviceStatus);

        return response;
    }


    // @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addProvinceRequest")
    // @ResponsePayload
    // public DBResponse
    // addProvinceRequest(uteq.appdist.apipaises.soapws.entities.province.Province
    // province) {
    // DBResponse response = new DBResponse();

    // response = provinceService.addProvince(province);

    // return response;
    // }

    // @PayloadRoot(namespace = NAMESPACE_URI, localPart = "editProvinceRequest")
    // @ResponsePayload
    // public DBResponse
    // editProvinceRequest(uteq.appdist.apipaises.soapws.entities.province.Province
    // province) {
    // DBResponse response = new DBResponse();

    // response = provinceService.editProvince(province);

    // return response;
    // }

    // @PayloadRoot(namespace = NAMESPACE_URI, localPart = "delProvinceRequest")
    // @ResponsePayload
    // public DBResponse delProvinceRequest(int provinceId) {
    // DBResponse response = new DBResponse();

    // response = provinceService.delProvince(provinceId);

    // return response;
    // }

}

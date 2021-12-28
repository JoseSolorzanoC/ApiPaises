
package uteq.appdist.apipaises.soapws.entities.province;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.province.Province;
import uteq.appdist.apipaises.soapws.generated.interfaces.province.GetProvinceResponse;

@Endpoint
public class ProvinceEndpoint {
    private static final String NAMESPACE_URI = "http://province.interfaces.generated.soapws.apipaises.appdist.uteq";

    private ProvinceService provinceService;

    @Autowired
    public ProvinceEndpoint(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProvinceRequest")
    @ResponsePayload
    public GetProvinceResponse getAllProvinces() {
        GetProvinceResponse response = new GetProvinceResponse();

        for (uteq.appdist.apipaises.soapws.entities.province.Province source : provinceService.getAllProvinces()) {
            Province target = new Province();
            BeanUtils.copyProperties(source, target);

            response.getProvince().add(target);
        }

        return response;
    }

}

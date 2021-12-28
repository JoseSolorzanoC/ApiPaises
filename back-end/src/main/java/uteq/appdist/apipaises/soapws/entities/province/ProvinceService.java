package uteq.appdist.apipaises.soapws.entities.province;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.appdist.apipaises.soapws.shared.DBResponse;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;
    
    //Get All Provinces
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    //Insert Province
    public DBResponse addProvince(Province province){

        return provinceRepository.addProvince(province);

    }

    //Update Province
    public DBResponse editProvince(Province province){

        return provinceRepository.editProvince(province);

    }

    //Delete Province
    public DBResponse delProvince(int provinceId){

        return provinceRepository.delProvince(provinceId);

    }


}

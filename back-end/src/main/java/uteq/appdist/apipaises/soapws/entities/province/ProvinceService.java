package uteq.appdist.apipaises.soapws.entities.province;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.appdist.apipaises.soapws.shared.DBResponse;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    // Get All Provinces
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    // Get One Province
    public Optional<Province> getProvinceById(int id) {
        return provinceRepository.getProvinceById(id);
    }

    // //Insert Province
    // public DBResponse addProvince(Province province){

    // return provinceRepository.saveProvince(province.provinceName,
    // province.provinceFlag,province.provinceCapital,province.provinceAlt,province.provinceLat,
    // province.provinceState,province.provinceCallCode, province.countryId);

    // }

    public DBResponse saveProvince(Province province,String nameCountry) {
        return provinceRepository.saveProvince(province.provinceName,
                province.provinceFlag, province.provinceCapital, province.provinceAlt, province.provinceLat,
                province.provinceState, province.provinceCallCode,
                nameCountry);
    }


    // Update Province
    public DBResponse editProvince(Province province) {

        return provinceRepository.editProvince(province);

    }

    // Delete Province
    public DBResponse delProvince(int provinceId) {

        return provinceRepository.delProvince(provinceId);

    }

}

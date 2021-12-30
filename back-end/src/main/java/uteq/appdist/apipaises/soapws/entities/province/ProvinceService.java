package uteq.appdist.apipaises.soapws.entities.province;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.appdist.apipaises.soapws.entities.country.Country;
import uteq.appdist.apipaises.soapws.entities.country.CountryRepository;
import uteq.appdist.apipaises.soapws.shared.DBResponse;
import uteq.appdist.apipaises.soapws.shared.ServiceResponse;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private CountryRepository countryRepository;

    // Get All Provinces
    public List<Province> getAllProvinces() {
        return provinceRepository.getAllProvinces();
    }

    // Get All Provinces by Country
    public List<Province> getAllProvincesByCountry(String iso2) {
        return provinceRepository.getAllProvincesByCountry(iso2);
    }


    public ServiceResponse saveProvince(Province province,String iso2) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus(-1);

    

        Optional<Country> country= countryRepository.getCountryByIso2(iso2);

        countryRepository.getCountryByCallCode(iso2,0);
        DBResponse dbResponse;

        // Validación de que no exista un una provincia con el mismo nombre a registrar
        if (provinceRepository.getProvinceByName(province.getProvinceName(), country.get().getCountryId()).isPresent()) {
            serviceResponse.setAdditionalMessage("Ya existe una Provincia con el nombre ingresado");
            return serviceResponse;
        }

        // Validación de que no exista una provincia con el código de llamada a registrar
        if (provinceRepository.getProvinceByCallCode(province.getProvinceCallCode(), country.get().getCountryId()).size()>0) {
            serviceResponse.setAdditionalMessage("Ya existe una provincia con el código de llamada ingresado");
            return serviceResponse;
        }

        try {
            dbResponse = provinceRepository.saveProvince(province.getProvinceName(),
                    province.getProvinceFlag(), province.getProvinceCapital(), province.getProvinceAlt(),
                    province.getProvinceLat(),province.getProvinceState(),province.getProvinceCallCode(),
                    iso2);
        } catch (Exception e) {
            serviceResponse
                    .setAdditionalMessage(
                            String.format("Error al realizar el registro. Error Message => %s", e.getMessage()));
            return serviceResponse;
        }

        if (dbResponse.getStatus() != 2) {
            serviceResponse
                    .setAdditionalMessage(
                            "Ocurrió un error inesperado al intentar registrar la provincia. Inténtelo nuevamente más tarde");
            return serviceResponse;
        }

        serviceResponse.setIdentif(dbResponse.getIdentif());
        serviceResponse.setStatus(0);
        serviceResponse.setAdditionalMessage("Registro exitoso");

        return serviceResponse;
    }

    // public DBResponse saveProvince(Province province,String nameCountry) {
    //     return provinceRepository.saveProvince(province.provinceName,
    //             province.provinceFlag, province.provinceCapital, province.provinceAlt, province.provinceLat,
    //             province.provinceState, province.provinceCallCode,
    //             nameCountry);
    // }


    // // Get One Province
    // public Optional<Province> getProvinceById(int id) {
    //     return provinceRepository.getProvinceById(id);
    // }

    // // //Insert Province
    // // public DBResponse addProvince(Province province){

    // // return provinceRepository.saveProvince(province.provinceName,
    // // province.provinceFlag,province.provinceCapital,province.provinceAlt,province.provinceLat,
    // // province.provinceState,province.provinceCallCode, province.countryId);

    // // }

    


    // // Update Province
    // public DBResponse editProvince(Province province) {

    //     return provinceRepository.editProvince(province);

    // }

    // // Delete Province
    // public DBResponse delProvince(int provinceId) {

    //     return provinceRepository.delProvince(provinceId);

    // }

}

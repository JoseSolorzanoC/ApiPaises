package uteq.appdist.apipaises.soapws.entities.province;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;
    
    public List<Province> getAllProvinces() {
        return provinceRepository.getAllProvinces();
    }

}

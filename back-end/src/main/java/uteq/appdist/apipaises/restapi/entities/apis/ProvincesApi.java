package uteq.appdist.apipaises.restapi.entities.apis;

import uteq.appdist.apipaises.restapi.entities.models.ProvincesModel;
import uteq.appdist.apipaises.restapi.entities.models.countriesModel;
import uteq.appdist.apipaises.restapi.entities.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
   

@RestController
@RequestMapping("/ProvincesApi")

public class ProvincesApi {
    
    @Autowired
    ProvincesApi R ;


    /*@GetMapping ("/listProvinces") 
    public List<ProvincesModel>Provinces( @RequestParam(value= "name", defaultValue = "usuario") String name) {
            return R.;
	}*/

    @GetMapping ("/capitalProvince") 
    public String province( @RequestParam(value= "Province", defaultValue = "usuario") String Province) {
            return Province;
	}

    @GetMapping ("/flagProvince") 
    public String flag( @RequestParam(value= "flagName", defaultValue = "usuario") String flagName) {
            return flagName;
	}

    @GetMapping ("/listCDProvinces") 
    public String CallCodesProvi( @RequestParam(value= "codesProvin", defaultValue = "usuario") String codesProvin) {
            return codesProvin;
	}

}
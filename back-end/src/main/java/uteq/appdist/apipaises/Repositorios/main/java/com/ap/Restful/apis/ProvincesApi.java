package uteq.appdist.apipaises.Repositorios.main.java.com.ap.Restful.apis;

import com.ap.Restful.repository.ProvincesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
   

@RestController
@RequestMapping("/ProvincesApi")

public class ProvincesApi {
    
    @Autowired
    ProvincesRepository R ;


    @GetMapping ("/listProvinces") 
    public String NameProvinces( @RequestParam(value= "name", defaultValue = "usuario") String name) {
            return R.findAll().toString();
	}

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

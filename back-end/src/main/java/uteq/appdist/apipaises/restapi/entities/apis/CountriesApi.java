package uteq.appdist.apipaises.restapi.entities.apis;

import java.util.List;

import uteq.appdist.apipaises.restapi.entities.models.countriesModel;
import uteq.appdist.apipaises.restapi.entities.services.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/CountriesApi")
public class CountriesApi {

    
    @Autowired
    CountriesService Servi;
    @GetMapping ("/findAll") 
    public ResponseEntity<List<countriesModel>> findAll() {
          List<countriesModel> P=Servi.findAll();
          if (P != null) {
            return ResponseEntity.ok(P);
        } else {
            return ResponseEntity.notFound().build();
        }
           
	}

    @GetMapping("/findByname")
    public String findname(@RequestParam(value= "name", defaultValue = "usuario") String name) {
        //String r=Servi.findByid("61cb5671b01c99996e71bb92");
        
        return Servi.findByname(name);
    }

    @GetMapping("/findByenglishName")
    public String findByenglishName(@RequestParam(value= "englishName", defaultValue = "usuario") String englishName) {
        return Servi.findByenglishName(englishName);
    }

    @GetMapping("/findBylatudeandlongitude")
    public String findlatudeandlongitude(@RequestParam(value= "latitude", defaultValue = "0") Double latitude ,
                                        @RequestParam(value= "longitude", defaultValue = "0") Double longitude) {
        
        return Servi.findlatudeandlongitude(latitude, longitude);
    }

}
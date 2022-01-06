package uteq.appdist.apipaises.restapi.entities.apis;

import java.util.ArrayList;
import java.util.List;

import uteq.appdist.apipaises.restapi.entities.models.countriesModel;
import uteq.appdist.apipaises.restapi.entities.repository.CountriesRepository;
import uteq.appdist.apipaises.restapi.entities.services.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/CountriesApi")
public class CountriesApi {

    
    @Autowired
    CountriesService Servi;
    CountriesRepository R;

  // @RequestMapping(value = "/findAll",method = RequestMethod.GET, produces = "application/json")
  @GetMapping()
   public ResponseEntity<List<countriesModel>> findAll() {
        /*  List<countriesModel> P=Servi.findAll();
          if (P != null) {
            return ResponseEntity.ok(P);
        } else {
            return ResponseEntity.notFound().build();
        }*/
       
        try {
            List<countriesModel> userTyps = new ArrayList<countriesModel>();

            R.findAll().forEach(userTyps::add);

            if (userTyps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userTyps, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

	}



    @RequestMapping(value = "/findByname",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody ResponseEntity<List<countriesModel>> findname(@RequestParam(value= "name", defaultValue = "usuario") String name) {
        //String r=Servi.findByid("61cb5671b01c99996e71bb92");
        try {
            List<countriesModel> userTyps = new ArrayList<countriesModel>();

            R.findByname(name).forEach(userTyps::add);

            if (userTyps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userTyps, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
       // return Servi.findByname(name);
    }

    //@GetMapping("/findByenglishName")
    @RequestMapping(value = "/findByenglishName",method = RequestMethod.GET, produces = "application/json")
    public String findByenglishName(@RequestParam(value= "englishName", defaultValue = "usuario") String englishName) {
        return Servi.findByenglishName(englishName);
    }

    //@GetMapping("/findBylatudeandlongitude")
    @RequestMapping(value = "/findBylatudeandlongitude",method = RequestMethod.GET, produces = "application/json")
    public String findlatudeandlongitude(@RequestParam(value= "latitude", defaultValue = "0") Double latitude ,
                                        @RequestParam(value= "longitude", defaultValue = "0") Double longitude) {
        
        return Servi.findlatudeandlongitude(latitude, longitude);
    }

}

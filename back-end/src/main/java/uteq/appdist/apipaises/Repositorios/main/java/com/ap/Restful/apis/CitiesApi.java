package uteq.appdist.apipaises.Repositorios.main.java.com.ap.Restful.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CitiesApi")


public class CitiesApi {
    
    @Autowired
    CitiesApi CityDao ;
   

    @GetMapping ("/ListCities") 
    public String listCities( @RequestParam(value= "cities", defaultValue = "usuario") String cities) {
        
            return cities;
	}


    @GetMapping ("/flagCountry") 
    public String flag( @RequestParam(value= "flagName", defaultValue = "usuario") String flagName) {
            return flagName;
	}

    @GetMapping ("/listCallCodes") 
    public String CallCodes( @RequestParam(value= "codes", defaultValue = "usuario") String codes) {
            return codes;
	}


    @GetMapping ("/CitiesCoordinates") 
    public String citiesCoordinates( @RequestParam(value= "coordinates", defaultValue = "usuario") String coordinates) {
            return coordinates;
	}

    @GetMapping ("/CitieState") 
    public String StateCities( @RequestParam(value= "state", defaultValue = "usuario") String state) {
            return state;
	}


}

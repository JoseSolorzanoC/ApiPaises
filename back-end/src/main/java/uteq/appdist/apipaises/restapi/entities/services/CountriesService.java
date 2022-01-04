package uteq.appdist.apipaises.restapi.entities.services;

import java.util.List;
import java.util.Optional;

import uteq.appdist.apipaises.restapi.entities.models.countriesModel;
import uteq.appdist.apipaises.restapi.entities.repository.CountriesRepository;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ConvertOperators.ToString;
import org.springframework.stereotype.Service;

@Service
public class CountriesService {

    @Autowired
    CountriesRepository R;
    countriesModel    Model;

    public List<countriesModel> findAll(){

        return R.findAll();
    }
    
    public String findByname(String name){
        return R.findByname(name);
    }

    public String findByid(String id){
        return R.findByid(id);
    }

    public String findByenglishName(String englishName){
        
        return R.findByenglishName(englishName);
    }
    

    

    public String findlatudeandlongitude(Double latitude, Double longitude){
        String Rlatitude=R.findBylatitude(latitude);
        String Rlongitude=R.findBylongitude(longitude);
        
        return Rlatitude+ "\n" +Rlongitude;
    }
    
    public countriesModel save(countriesModel entity){
        
        return R.save(entity);
    }
    
    public countriesModel insert(countriesModel entity){
        return R.insert(entity);
    }

    public void delete(countriesModel entity){
        R.delete(entity);
    }
    
}

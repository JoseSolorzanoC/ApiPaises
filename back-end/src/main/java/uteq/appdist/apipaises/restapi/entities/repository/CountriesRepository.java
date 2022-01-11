package uteq.appdist.apipaises.restapi.entities.repository;

import java.io.Serializable;
import java.util.List;

import uteq.appdist.apipaises.restapi.entities.models.countriesModel;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "CountriesRepository", path = "CountriesRepository")
public interface CountriesRepository  extends MongoRepository<countriesModel,String>{
 
    String findByname(@Param("name") String name);
    String findByenglishName(@Param("englishName") String englishName);
    String findBycapital(@Param("capital") String capital);
    String findBylatitude(@Param("latitude") Double latitude);
    String findBylongitude(@Param("longitude") Double longitude);
   // String findByid(@Param("id") Long id);
   //countriesModel save(@Param("entity") countriesModel entity);
     
     countriesModel save(countriesModel entity);
    
    void delete(@Param("entity") countriesModel entity);
   // String findByid(@Param("id") String id);
  
}


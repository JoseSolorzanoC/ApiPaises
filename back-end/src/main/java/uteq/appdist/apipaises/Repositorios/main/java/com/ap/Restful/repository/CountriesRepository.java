package uteq.appdist.apipaises.Repositorios.main.java.com.ap.Restful.repository;


import java.util.List;

import com.ap.Restful.models.countriesModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;

@RepositoryRestResource(collectionResourceRel = "CountriesRepository", path = "CountriesRepository")
public interface CountriesRepository  extends MongoRepository<countriesModel,Long>{

    String findByname(@Param("name") String name);
    String findByenglishName(@Param("englishName") String englishName);
    String findBycapital(@Param("capital") String capital);
    String findBylatitude(@Param("latitude") Double latitude);
    String findBylongitude(@Param("longitude") Double longitude);
   // String findByid(@Param("id") Long id);
    countriesModel save(@Param("entity") countriesModel entity);
    countriesModel insert(@Param("entity") countriesModel entity);
    void delete(@Param("entity") countriesModel entity);
    List<countriesModel> findAll();
    String findByid(@Param("id") String id);
}

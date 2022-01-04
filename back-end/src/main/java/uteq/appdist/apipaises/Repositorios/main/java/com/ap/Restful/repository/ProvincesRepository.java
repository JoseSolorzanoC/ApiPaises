package uteq.appdist.apipaises.Repositorios.main.java.com.ap.Restful.repository;


import com.ap.Restful.models.ProvincesModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "Reproprovinces", path = "Reproprovinces")
public interface ProvincesRepository extends MongoRepository<ProvincesModel,String>{
    
      String findByname(@Param("name") String name);
}

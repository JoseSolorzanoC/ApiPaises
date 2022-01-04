package uteq.appdist.apipaises.restapi.entities.repository;


import uteq.appdist.apipaises.restapi.entities.models.ProvincesModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource (collectionResourceRel = "Reproprovinces", path = "Reproprovinces")
public interface ProvincesRepository extends MongoRepository<ProvincesModel,Long>{
    

}

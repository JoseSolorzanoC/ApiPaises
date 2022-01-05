package uteq.appdist.apipaises.restapi.entities.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uteq.appdist.apipaises.restapi.entities.models.UserType;

@RepositoryRestResource(collectionResourceRel = "UserTypeRepository", path = "UserTypeRepository")
public interface UserTypeRepository extends MongoRepository<UserType,Serializable> {
    String findByusertype(@Param("usertype") String usertype);
    String findByusertypeid(@Param("usertypeid") String usertypeid);

}

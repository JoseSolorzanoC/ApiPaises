package uteq.appdist.apipaises.restapi.entities.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value ="usertype" )
public class UserType {
    @Id
    private String usertypeid;
    private String usertype;
    private String createby_userid;
    
}

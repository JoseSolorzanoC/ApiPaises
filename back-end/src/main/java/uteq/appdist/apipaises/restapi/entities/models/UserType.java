package uteq.appdist.apipaises.restapi.entities.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collation ="usertype" )
public class UserType {
    @Id
    private int idusertype;
    private String usertype;
    private int userid;
    
}

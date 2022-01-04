package uteq.appdist.apipaises.restapi.entities.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value ="person" )
public class personModel {
    @Id
    private String personid;
    private String firstname_person;
    private String secondname_person;
    private String email_person;
    private String phone_person;
    
}

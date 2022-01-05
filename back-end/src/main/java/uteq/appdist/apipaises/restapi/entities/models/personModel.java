package uteq.appdist.apipaises.restapi.entities.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value ="person" )
public class personModel {
    @Id
    @NotNull
    private String personid;
    private String firstname_person;
    private String secondname_person;
    private String email_person;
    private String phone_person;
    
}

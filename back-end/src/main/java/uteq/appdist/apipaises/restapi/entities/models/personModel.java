package uteq.appdist.apipaises.restapi.entities.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collation ="person" )
public class personModel {
    @Id
    private int idperson;
    private String firtname;
    private String secondname;
    private String email;
    private String phone;

}

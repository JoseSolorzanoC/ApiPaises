package uteq.appdist.apipaises.restapi.entities.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
@Data
@Document(value ="users" )
public class usersModels {
    @Id
    private String userid;
    private String user_name;
    private String user_password;
    private String usertypeid;
    private String personid;
}

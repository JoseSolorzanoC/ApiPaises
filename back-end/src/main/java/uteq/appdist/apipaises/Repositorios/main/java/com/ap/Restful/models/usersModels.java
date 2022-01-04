package uteq.appdist.apipaises.Repositorios.main.java.com.ap.Restful.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
@Data
@Document(collation ="user" )
public class usersModels {
    @Id
    private int iduser;
    private String user;
    private String password;
    private int idusertype;
    private int idperson;
}

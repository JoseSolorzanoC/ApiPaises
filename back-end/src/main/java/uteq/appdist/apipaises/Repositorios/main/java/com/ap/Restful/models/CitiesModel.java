
package uteq.appdist.apipaises.Repositorios.main.java.com.ap.Restful.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import net.minidev.json.JSONObject;

@Data
@Document(collation ="Cities" )
public class CitiesModel {
    @Id
    private int id;
    private String name;
    private String englishName;
    private String flag;
    private String [] coordinates;
    private String CallCode;
    private char state_city;
    private int idprovinces;



    
}

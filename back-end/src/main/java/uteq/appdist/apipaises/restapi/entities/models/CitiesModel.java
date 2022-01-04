
package uteq.appdist.apipaises.restapi.entities.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

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

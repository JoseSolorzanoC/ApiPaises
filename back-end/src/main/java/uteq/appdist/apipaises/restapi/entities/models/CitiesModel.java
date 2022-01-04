
package uteq.appdist.apipaises.restapi.entities.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value ="cities" )
public class CitiesModel {
    @Id
    private Long cityid;
    private Long provinceid;
    private String name_city;
    private String cabecera_city;
    private String flag_city;
    private String callcode_city;
    private String coordinate_alt;
    private String coordinate_lat;
    private String state_city;



    
}

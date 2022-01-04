package uteq.appdist.apipaises.restapi.entities.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data

@Document(value ="provinces")

public class ProvincesModel {
    
    @Id
    private int id;
    private String name;
    private String englishName;
    private String flag;
    private String capitalProvinces;
    private String [] coordinates;
    private String CallCode;
    private char state_province;
    private int idcountries;;

}

package uteq.appdist.apipaises.restapi.entities.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data

@Document(value ="provinces")

public class ProvincesModel {
    
    @Id
    @NotNull
    private Long provinceid;
    private Long countryid;
    private String name_province;
    private String capital_province;
    private String flag_province;
    private String callcode_province;
    private String coordinate_alt;
    private String coordinate_lat;
    private String state_province;



}

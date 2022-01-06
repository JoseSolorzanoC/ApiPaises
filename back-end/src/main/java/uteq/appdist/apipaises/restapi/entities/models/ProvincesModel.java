package uteq.appdist.apipaises.restapi.entities.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(value ="provinces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvincesModel {
    
    
    @NotNull
    @Field(name="provinceid")
    Long provinceid;

    
    @Field(name="countryid")
    Long countryid;

    
    @Field(name="name_province")
    String nameprovince;

    
    @Field(name="capital_province")
    String capital_province;

    
    @Field(name="flag_province")
    String flag_province;

    
    @Field(name="callcode_province")
    String callcode_province;
    
    
    @Field(name="coordinate_alt")
    String coordinate_alt;

  
    @Field(name="coordinate_lat")
    String coordinate_lat;

    
    @Field(name="state_province")
    String state_province;



    

}

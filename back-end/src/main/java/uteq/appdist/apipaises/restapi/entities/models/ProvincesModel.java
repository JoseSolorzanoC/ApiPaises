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
    String capitalprovince;

    
    @Field(name="flag_province")
    String flagprovince;

    
    @Field(name="callcode_province")
    String callcodeprovince;
    
    
    @Field(name="coordinate_alt")
    String coordinatealt;

  
    @Field(name="coordinate_lat")
    String coordinatelat;

    
    @Field(name="state_province")
    String stateprovince;



    

}

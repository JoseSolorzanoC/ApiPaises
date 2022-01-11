package uteq.appdist.apipaises.restapi.entities.models;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.security.cert.Extension;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.bson.conversions.Bson;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value="countries1")
public class countriesModel{
 


    @Id
    @Field(name="Id")
    private String id; 

    @Field(name="countryId")
    private Long countryId;

    @Field(name="name")
    private String name;

    @Field(name="englishName")
    private String englishName;

    @Field(name="flag")
    private String flag;

    @Field(name="capital")
    private String capital;

    @Field(name="latitude")
    private Double latitude;

    @Field(name="longitude")
    private Double longitude;

    @Field(name="countryCodes")
    private JSONObject countryCodes;

    @Field(name="callCode")
     private Array CallCode;

    


}

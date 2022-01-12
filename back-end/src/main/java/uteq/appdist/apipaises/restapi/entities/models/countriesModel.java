package uteq.appdist.apipaises.restapi.entities.models;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.security.cert.Extension;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.bson.conversions.Bson;

import org.hibernate.validator.constraints.URL;
import org.springframework.boot.configurationprocessor.json.JSONObject;

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
    @NotNull
    @Field(name="Id")
    private String id; 


    @Field(name="countryId")
    private Long countryId;

    @Size (min = 4, max = 56, message = "La longuitud de los digitos es de 4 a 56 carácteres")
    @Field(name="name")
    @Pattern (regexp = "^[a-zA-Z]+$")
    private String name;

    @Size (min = 4, max = 25, message = "La longuitud de los digitos es de 4 a 25 carácteres")
    @Field(name="englishName")
    @Pattern (regexp = "^[a-zA-Z]+$")
    private String englishName;

    @Size (min = 4, max = 150, message = "La longuitud de los digitos es de 4 a 150 carácteres")
    @Field(name="flag")
    @URL //Valida que la cadena anotada es una URL.
    private String flag;

    @Size (min = 4, max = 30, message = "La longuitud de los digitos es de 4 a 30 carácteres")
    @Field(name="capital")
    @Pattern (regexp = "^[a-zA-Z]+$")
    private String capital;

    @Size (min = -0, max = 56, message = "150")
    @Field(name="latitude")
    @Pattern (regexp = "^[0-9]+(,[0-9]+)?$")
    private Double latitude;

    @Size (min = -0, max = 56, message = "150")
    @Field(name="longitude")
    @Pattern (regexp = "^[0-9]+(,[0-9]+)?$")
    private Double longitude;

    @Size (min = 1, max = 3, message = "Los longuitud de los codigos de paises es entre 1 y 3 carácteres")
    @Field(name="countryCodes")
    private JSONObject countryCodes;

    @Size (min = 1, max = 4, message = "Los longuitud de los codigos de paises es entre 1 y 4 carácteres")
    @Field(name="callCode")
     private Array CallCode;



}

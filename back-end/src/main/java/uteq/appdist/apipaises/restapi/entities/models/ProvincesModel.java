package uteq.appdist.apipaises.restapi.entities.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
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
    
    
    @NotNull(message = "Debes especificar el ID")
    @Field(name="provinceid")
    @Id
    Long provinceid;

    @NotNull
    @Field(name="countryid")
    @Id
    Long countryid;

    
    @Size (min = 4, max = 56, message = "La longuitud de los digitos es de 4 a 56 carácteres")
    @Pattern (regexp = "^[a-zA-Z]+$")
    @Field(name="name_province")
    String nameprovince;

    @Size (min = 4, max = 56, message = "La longuitud de los digitos es de 4 a 56 carácteres")
    @Pattern (regexp = "^[a-zA-Z]+$")
    @Field(name="capital_province")
    String capitalprovince;

    @Size (min = 4, max = 150, message = "La longuitud de los digitos es de 4 a 150 carácteres")
    @URL //Valida que la cadena anotada es una URL.
    @Field(name="flag_province")
    String flagprovince;

    @Size (min = 1, max = 4, message = "Los longuitud de los codigos de paises es entre 1 y 4 carácteres")
    @Field(name="callcode_province")
    String callcodeprovince;
    
    @Size (min = -0, max = 56, message = "150")
    @Pattern (regexp = "^[0-9]+(,[0-9]+)?$")
    @Field(name="coordinate_alt")
    String coordinatealt;

    @Size (min = -0, max = 56, message = "150")
    @Pattern (regexp = "^[0-9]+(,[0-9]+)?$")
    @Field(name="coordinate_lat")
    String coordinatelat;

    
    @Field(name="state_province")
    String stateprovince;



    

}

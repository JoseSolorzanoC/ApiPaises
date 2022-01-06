
package uteq.appdist.apipaises.restapi.entities.models;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value ="cities" )
public class CitiesModel {
    @Id
    @NotNull
    @Field(name="cityid")
    private Long cityid;

    @Field(name="provinceid")
    private Long provinceid;

    @Field(name="name_city")
    private String namecity;

    @Field(name="cabecera_city")
    private String cabeceracity;

    @Field(name="flag_city")
    private String flagcity;

    @Field(name="callcode_city")
    private String callcodecity;

    @Field(name="coordinate_alt")
    private String coordinatealt;

    @Field(name="coordinate_lat")
    private String coordinatelat;

    @Field(name="state_city")
    private String statecity;



    
}

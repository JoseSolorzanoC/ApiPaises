
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
    private String name_city;

    @Field(name="cabecera_city")
    private String cabecera_city;

    @Field(name="flag_city")
    private String flag_city;

    @Field(name="callcode_city")
    private String callcode_city;

    @Field(name="coordinate_alt")
    private String coordinate_alt;

    @Field(name="coordinate_lat")
    private String coordinate_lat;

    @Field(name="state_city")
    private String state_city;



    
}

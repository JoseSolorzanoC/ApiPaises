package uteq.appdist.apipaises.restapi.entities.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
@Document(value ="person" )
public class personModel {
    @Id
    @NotNull
    @Field(name="personid")
    private String personid;

    @Field(name="firstname_person")
    @Size (min = 1, max = 45, message = "La longuitud de los digitos es de 1 a 45 carácteres")
    @Pattern (regexp = "^[a-zA-Z]+$")
    private String firstnameperson;

    @Field(name="secondname_person")
    @Size (min = 1, max = 45, message = "La longuitud de los digitos es de 1 a 45 carácteres")
    @Pattern (regexp = "^[a-zA-Z]+$")
    private String secondnameperson;

    @Field(name="email_person")
    @Size (min = 1, max = 45, message = "La longuitud de los digitos es de 1 a 45 carácteres")
    @Pattern (regexp = "^[a-zA-Z]+$")
    private String emailperson;

    @Field(name="phone_person")
    @Size (min = 1, max = 15, message = "La longuitud de los digitos es de 4 a 30 carácteres")
    @Pattern (regexp = "^[0-9]+(,[0-9]+)?$")
    private String phoneperson;
    
}

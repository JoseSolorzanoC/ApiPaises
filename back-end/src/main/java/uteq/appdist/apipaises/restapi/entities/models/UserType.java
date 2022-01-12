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
@Document(value ="usertype" )
public class UserType {

    @NotNull
    @Field(name="usertypeid")
    @Id
    private String usertypeid;

    
    @Field(name="usertype")
    @Size (min = 4, max = 20, message = "La longuitud de los digitos es de 4 a 20 carácteres")
    @Pattern (regexp = "^[a-zA-Z]+$")
    private String usertype;

    @Field(name="createby_userid")
    @Size (min = 4, max = 20, message = "La longuitud de los digitos es de 4 a 20 carácteres")
    @Pattern (regexp = "^[a-zA-Z]+$")
    private String createbyuserid;
    
}

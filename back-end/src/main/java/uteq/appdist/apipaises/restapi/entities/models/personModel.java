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
@Document(value ="person" )
public class personModel {
    @Id
    @NotNull
    @Field(name="personid")
    private String personid;

    @Field(name="firstname_person")
    private String firstnameperson;

    @Field(name="secondname_person")
    private String secondnameperson;

    @Field(name="email_person")
    private String emailperson;

    @Field(name="phone_person")
    private String phoneperson;
    
}

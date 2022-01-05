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
@Document(value ="users" )
public class usersModels {
    @Id
    @NotNull
    @Field(name="userid")
    private String userid;

    @Field(name="user_name")
    private String user_name;

    @Field(name="user_password")
    private String user_password;

    @Field(name="usertypeid")
    private String usertypeid;

    @Field(name="personid")
    private String personid;
}

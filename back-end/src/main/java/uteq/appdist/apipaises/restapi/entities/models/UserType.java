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
@Document(value ="usertype" )
public class UserType {
    @Id
    @NotNull
    @Field(name="usertypeid")
    private String usertypeid;

    @Field(name="usertype")
    private String usertype;

    @Field(name="createby_userid")
    private String createby_userid;
    
}

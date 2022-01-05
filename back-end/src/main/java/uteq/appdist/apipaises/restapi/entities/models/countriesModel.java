package uteq.appdist.apipaises.restapi.entities.models;
import java.io.Serializable;
import java.security.cert.Extension;
import java.sql.Array;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(value ="countries")
public class countriesModel implements Serializable {
    @Id
    @NotNull
    @Field(name="id")
    private Long id;

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

    @Override
  public String toString() {
    return "{" + "id=" + this.id + ", name='" + this.name + '\'' + ", capital='" + this.capital + '\'' + '}';
  }
  public String ListToString(List<countriesModel> Model){
    String ModelString="";
    for(int i=0; i<Model.size();i++){
        countriesModel M=Model.get(i);
        ModelString+= M.toString();
    }

    return ModelString;
  }

}

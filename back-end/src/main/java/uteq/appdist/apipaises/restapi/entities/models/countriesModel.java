package uteq.appdist.apipaises.restapi.entities.models;
import java.io.Serializable;
import java.security.cert.Extension;
import java.sql.Array;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;




@Data 
@Document(value ="countries")
public class countriesModel {
    @Id
    private Long id;
    private String name;
    private String englishName;
    private String flag;
    private String capital;
    private Double latitude;
    private Double longitude;
    private JSONObject countryCodes;
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

package uteq.appdist.apipaises.soapws.entities.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbcity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {
    @Id
    @SequenceGenerator(name = "tbcity_cityid_seq", sequenceName = "tbcity_cityid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbcity_cityid_seq")
    @Column(name = "cityid")
    int cityId;

    @Column(name = "name_city")
    String cityName;

    @Column(name = "flag_city")
    String cityFlag;
    
    @Column(name = "cabecera_city")
    String cityCabecera;

    @Column(name = "coordinate_alt_city")
    float cityAlt = 0;

    @Column(name = "coordinate_lat_city")
    float cityLat = 0;

    @Column(name = "callcode_city")
    String cityCallCode;

    @Column(name = "state_city")
    String cityState;

    @Column(name = "provinceid")
    int cityProvinceId;
}

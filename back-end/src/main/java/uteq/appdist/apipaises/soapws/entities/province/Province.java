package uteq.appdist.apipaises.soapws.entities.province;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbprovinces")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Province {
    
    @Id
    @SequenceGenerator(name = "tbprovinces_provinceid_seq", sequenceName = "tbprovinces_provinceid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbprovinces_provinceid_seq")
   
    @Column(name = "provinceid")
    int provinceId;

    @Column(name = "name_province")
    String provinceName;

    @Column(name = "flag_province")
    String provinceFlag;

    @Column(name = "capital_province")
    String provinceCapital;

    @Column(name = "coordinate_alt_province")
    @Nullable
    Float provinceAlt;

    @Column(name = "coordinate_lat_province")
    @Nullable
    Float provinceLat;

    @Column(name = "callcode_province")
    String provinceCallCode;

    @Column(name = "state_province")
    String provinceState;

    @Column(name = "countryid")
    int countryId;

}

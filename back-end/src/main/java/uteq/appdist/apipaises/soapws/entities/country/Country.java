package uteq.appdist.apipaises.soapws.entities.country;

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
@Table(name = "tbcountries")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Country {
    @Id
    @SequenceGenerator(name = "tbcountries_countryid_seq", sequenceName = "tbcountries_countryid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbcountries_countryid_seq")
    @Column(name = "countryid")
    int countryId;

    @Column(name = "name_country")
    String countryName;

    @Column(name = "flag_country")
    String countryFlag;

    @Column(name = "capital_country")
    String countryCapital;

    @Column(name = "coordinate_alt_country", columnDefinition = "numeric")
    float countryAlt = 0f;

    @Column(name = "coordinate_lat_country", columnDefinition = "numeric")
    float countryLat = 0f;

    @Column(name = "state_country")
    String countryState;

    @Column(name = "callcode_country")
    String countryCallCode;

    @Column(name = "tld_country")
    String countryTld;

    @Column(name = "iso3_country")
    String countryIso3;

    @Column(name = "iso2_country")
    String countryIso2;

    @Column(name = "fips_country")
    String countryFips;

    @Column(name = "ison_country")
    String countryIson;

    @Column(name = "englishname_country")
    String countryEnglishName;
}

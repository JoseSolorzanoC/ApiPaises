package uteq.appdist.apipaises.soapws.entities.country;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uteq.appdist.apipaises.soapws.shared.DBResponse;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "select * from fnselectcountry_prueba()", nativeQuery = true)
    public List<Country> getAllCountries();

    @Query(value = "select * from fnselectcountry_prueba(:select_id)", nativeQuery = true)
    public Optional<Country> getCountryById(int select_id);

    @Query(value = "select * from fninsertcountry(:nam, :flg,:cap,cast(:calt as numeric),cast(:clat as numeric),:stt,:ccd,:tld,:is3,:is2,:fps,:isn,:enm)", nativeQuery = true)
    public DBResponse saveCountry(
            @Param("nam") String countryName,
            @Param("flg") String countryFlag,
            @Param("cap") String countryCapital,
            @Param("calt") float countryAlt,
            @Param("clat") float countryLat,
            @Param("stt") String countryState,
            @Param("ccd") String countryCallCode,
            @Param("tld") String countryTld,
            @Param("is3") String countryIso3,
            @Param("is2") String countryIso2,
            @Param("fps") String countryFips,
            @Param("isn") String countryIson,
            @Param("enm") String countryEnglishName);

    @Query(value = "select * from tbcountries where name_country = :name", nativeQuery = true)
    public Optional<Country> getCountryByName(String name);

    @Query(value = "select count(*) from tbcountries where tld_country = :tld or iso3_country = :iso3 or iso2_country = :iso2 or fips_country = :fips or ison_country = :ison", nativeQuery = true)
    public int getCountryByCodes(String tld, String iso3, String iso2, String fips, String ison);

    @Query(value = "select * from tbcountries where callcode_country = :callCode", nativeQuery = true)
    public Optional<Country> getCountryByCallCode(String callCode);
}

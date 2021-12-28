package uteq.appdist.apipaises.soapws.entities.country;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import uteq.appdist.apipaises.soapws.shared.DBResponse;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "select * from fnselectcountry_prueba()", nativeQuery = true)
    public List<Country> getAllCountries();

    @Query(value = "select * from fnselectcountry_prueba(:select_id)", nativeQuery = true)
    public Optional<Country> getCountryById(int select_id);

    @Query()
    public DBResponse saveCountry(
            @Param("nam") String countryName,
            @Param("flg") String countryFlag,
            @Param("cap") String countryCapital,
            @Param("calt") Float countryAlt,
            @Param("clat") Float countryLat,
            @Param("stt") String countryState,
            @Param("ccd") String countryCallCode,
            @Param("tld") String countryTld,
            @Param("is3") String countryIso3,
            @Param("is2") String countryIso2,
            @Param("fps") String countryFips,
            @Param("isn") String countryIson,
            @Param("enm") String countryEnglishName);
}

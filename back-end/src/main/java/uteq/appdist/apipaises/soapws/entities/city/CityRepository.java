package uteq.appdist.apipaises.soapws.entities.city;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uteq.appdist.apipaises.soapws.shared.DBResponse;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query(value = "select * from fnselectcity_by_id_province(:pid)", nativeQuery = true)
    public List<City> getAllCitiesFromProvince(int pid);

    @Query(value = "select * from fnselectcity_by_id(:select_id)", nativeQuery = true)
    public Optional<City> getCityById(int select_id);

    @Query(value = "select * from fninsertcity(:nam, :flg,:cap,cast(:calt as numeric),cast(:clat as numeric),:stt,:ccd,:prv)", nativeQuery = true)
    public DBResponse saveCity(
            @Param("nam") String cityName,
            @Param("flg") String cityFlag,
            @Param("cap") String cityCabecera,
            @Param("calt") float cityAlt,
            @Param("clat") float cityLat,
            @Param("stt") String cityState,
            @Param("ccd") String cityCallCode,
            @Param("prv") int provinceId);

    @Query(value = "select * from tbcity where name_city = :name and (:cid = 0 or countryid != :cid) and provinceid = :pid", nativeQuery = true)
    public Optional<City> getCityByName(String name, int cid, int pid);

    @Query(value = "select * from tbcity where callcode_city = :cc and (:cid = 0 or countryid != :cid) and provinceid = :pid", nativeQuery = true)
    public Optional<City> getCityByCallCode(String cc, int cid, int pid);

    @Query(value = "select * from fnupdatecity(:cid, :nam, :flg,:cap,cast(:calt as numeric),cast(:clat as numeric),:stt,:ccd,:prv)", nativeQuery = true)
    public DBResponse updateCity(
            @Param("cid") int cityId,
            @Param("nam") String cityName,
            @Param("flg") String cityFlag,
            @Param("cap") String cityCabecera,
            @Param("calt") float cityAlt,
            @Param("clat") float cityLat,
            @Param("stt") String cityState,
            @Param("ccd") String cityCallCode,
            @Param("prv") int provinceId);
}

package uteq.appdist.apipaises.soapws.entities.province;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uteq.appdist.apipaises.soapws.generated.interfaces.province.ServiceStatus;
import uteq.appdist.apipaises.soapws.shared.DBResponse;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

     // Select All Provinces
     @Query(value = "select * from fnselectprovinces_iso2()", nativeQuery = true)
     public List<Province> getAllProvinces();

     // Select All Provinces
     @Query(value = "select * from fnselectprovinces_iso2(:iso2)", nativeQuery = true)
     public List<Province> getAllProvincesByCountry(String iso2);

     //Select all Name by Province
     @Query(value = "select * from tbprovinces where name_province = :name and countryid = :cid", nativeQuery = true)
    public List<Province> getProvinceByName(String name, int cid);

   //Select all Province by CallCode
    @Query(value = "select * from tbprovinces where callcode_province = :callCode and countryid = :cid", nativeQuery = true)
    public List<Province> getProvinceByCallCode(String callCode, int cid);


    
    // Insert Province
    @Query(value = "select * from fninsertprovince(:nam, :flg,:cap,cast(:calt as numeric),cast(:clat as numeric),:stt,:ccd,:iso2)", nativeQuery = true)
    public DBResponse saveProvince(
            @Param("nam") String provinceName,
            @Param("flg") String provinceFlag,
            @Param("cap") String provinceCapital,
            @Param("calt") Float provinceAlt,
            @Param("clat") Float provinceLat,
            @Param("stt") String provinceState,
            @Param("ccd") String provinceCallCode,
            @Param("iso2") String countryIso2);



    // Update Province
    @Query(value = "select * from fnupdateprovince(:pid,:nam, :flg,:cap,cast(:calt as numeric),cast(:clat as numeric),:stt,:ccd,:iso2)", nativeQuery = true)
    public DBResponse updateProvince(
        @Param("pid") int provinceId,
        @Param("nam") String provinceName,
        @Param("flg") String provinceFlag,
        @Param("cap") String provinceCapital,
        @Param("calt") Float provinceAlt,
        @Param("clat") Float provinceLat,
        @Param("stt") String provinceState,
        @Param("ccd") String provinceCallCode,
        @Param("iso2") String countryIso2);
}

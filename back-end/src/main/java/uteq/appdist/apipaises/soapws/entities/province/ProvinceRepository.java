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
    public Optional<Province> getProvinceByName(String name, int cid);

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
            @Param("iso2") String countryId);


 



//     //Select One Province
//     @Query(value = "select * from fnselectprovinces(:select_id)", nativeQuery = true)
//     public Optional<Province> getProvinceById(int select_id);




//     // Edit Province
//     @Procedure("fnupdateprovince")
//     DBResponse editProvince(Province province);

//     // Delete Province
//     @Procedure("fndeleteprovince")
//     DBResponse delProvince(int id);

}

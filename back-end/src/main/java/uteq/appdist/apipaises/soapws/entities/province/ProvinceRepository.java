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
     @Query(value = "select * from fnselectprovinces()", nativeQuery = true)
     public List<Province> getAllProvinces();

    //Select One Province
    @Query(value = "select * from fnselectprovinces(:select_id)", nativeQuery = true)
    public Optional<Province> getProvinceById(int select_id);

    // Insert Province
    @Query(value = "select * from fninsertcountry(:nam, :flg,:cap,cast(:calt as numeric),cast(:clat as numeric),:stt,:ccd,:ctr)", nativeQuery = true)
    public DBResponse saveProvince(
            @Param("nam") String provinceName,
            @Param("flg") String provinceFlag,
            @Param("cap") String provinceCapital,
            @Param("calt") Float provinceAlt,
            @Param("clat") Float provinceLat,
            @Param("stt") String provinceState,
            @Param("ccd") String provinceCallCode,
            @Param("ctr") String countryId);



    // Edit Province
    @Procedure("fnupdateprovince")
    DBResponse editProvince(Province province);

    // Delete Province
    @Procedure("fndeleteprovince")
    DBResponse delProvince(int id);

}

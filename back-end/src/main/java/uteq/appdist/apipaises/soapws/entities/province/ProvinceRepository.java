package uteq.appdist.apipaises.soapws.entities.province;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import uteq.appdist.apipaises.soapws.generated.interfaces.province.ServiceStatus;
import uteq.appdist.apipaises.soapws.shared.DBResponse;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> { 
    
    //Select All Provinces
    @Procedure("fnselectprovinces")
    List<Province> getAllProvinces();

    //Insert Province
    @Procedure("fninsertprovince")
    DBResponse addProvince(Province province);

    //Edit Province
    @Procedure("fnupdateprovince")
     DBResponse editProvince(Province province);


    //Delete Province
    @Procedure("fndeleteprovince")
     DBResponse delProvince(int id);

}

package uteq.appdist.apipaises.soapws.entities.province;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> { 
    
    //Select All Provinces
    @Procedure("fnselectprovinces")
    List<Province> getAllProvinces();

    //Insert Province
    @Procedure("fninsertprovince")
     void addProvince();


    //Edit Province

    //Delete Province

}

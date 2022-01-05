package uteq.appdist.apipaises.restapi.entities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.appdist.apipaises.restapi.entities.models.UserType;
import uteq.appdist.apipaises.restapi.entities.repository.UserTypeRepository;

@Service
public class UserTypeService {
    
    @Autowired
    UserTypeRepository R;
    UserType    Model;

    public String findByusertype(String usertype){
        return R.findByusertype(usertype);
    }

    public String findByusertypeid(String usertypeid){
        return R.findByusertype(usertypeid);
    }


}

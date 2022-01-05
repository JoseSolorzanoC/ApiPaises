package uteq.appdist.apipaises.restapi.entities.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uteq.appdist.apipaises.restapi.entities.services.UserTypeService;


@RestController
@RequestMapping("/UserTypeApis")

public class UsersTypesApi {
    
    @Autowired
    UserTypeService Servi;

    @GetMapping ("/listTypeUser") 
    public String LtypeUsers( @RequestParam(value= "typesusers", defaultValue = "usuario") String typesusers) {
            return typesusers;
	}

    @RequestMapping(value = "/findByUserType",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody String findname(@RequestParam(value= "usertype", defaultValue = "usuario") String usertype) {
        //String r=Servi.findByid("61cb5671b01c99996e71bb92");
        
        return Servi.findByusertype(usertype);
    }


    @RequestMapping(value = "/findByusertypeid",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody String findusertypeid(@RequestParam(value= "usertypeid", defaultValue = "usuario") String usertypeid) {
        //String r=Servi.findByid("61cb5671b01c99996e71bb92");
        
        return Servi.findByusertypeid(usertypeid);
    }

}

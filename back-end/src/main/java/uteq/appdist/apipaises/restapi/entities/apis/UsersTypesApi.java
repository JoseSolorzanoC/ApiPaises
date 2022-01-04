package uteq.appdist.apipaises.restapi.entities.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/UserTypeApis")

public class UsersTypesApi {
    
    @Autowired
    UsersTypesApi UserDAO;

    @GetMapping ("/listTypeUser") 
    public String LtypeUsers( @RequestParam(value= "typesusers", defaultValue = "usuario") String typesusers) {
            return typesusers;
	}

}

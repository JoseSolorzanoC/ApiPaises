package uteq.appdist.apipaises.restapi.entities.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/UserApis")


public class UsersApi {

    @Autowired
    UsersApi UserDAO;

    @GetMapping ("/listUsers") 
    public String Users( @RequestParam(value= "users", defaultValue = "usuario") String users) {
            return users;
	}

    @GetMapping ("/TypeUsers") 
    public String typeUsers( @RequestParam(value= "TUsers", defaultValue = "usuario") String TUsers) {
            return TUsers;
	}
    
    
}

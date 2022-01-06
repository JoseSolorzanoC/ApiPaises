package uteq.appdist.apipaises.restapi.entities.apis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uteq.appdist.apipaises.restapi.entities.models.UserType;
import uteq.appdist.apipaises.restapi.entities.models.usersModels;
import uteq.appdist.apipaises.restapi.entities.repository.UserTypeRepository;
import uteq.appdist.apipaises.restapi.entities.services.UserTypeService;


@RestController
@RequestMapping("/UserTypeApis")

public class UsersTypesApi {
    
    @Autowired
    UserTypeRepository repository;

    @GetMapping()
    public ResponseEntity<List<UserType>> getAlluserTyps() {
        try {
            List<UserType> userTyps = new ArrayList<UserType>();

            repository.findAll().forEach(userTyps::add);

            if (userTyps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userTyps, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/porUsuario")
    public ResponseEntity<List<UserType>> getuserTypesByusertype(@RequestParam(required = false) String usertype) {
        try {
            List<UserType> userTypes = new ArrayList<UserType>();

            repository.findByusertypeIgnoreCase(usertype).forEach(userTypes::add);

            if (userTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

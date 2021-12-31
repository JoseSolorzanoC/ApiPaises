package uteq.appdist.apipaises.soapws.entities.users;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import uteq.appdist.apipaises.soapws.generated.interfaces.user.ServiceStatus;
import uteq.appdist.apipaises.soapws.generated.interfaces.user.RegisterUserRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.user.RegisterUserResponse;
import uteq.appdist.apipaises.soapws.generated.interfaces.user.UserResponse;
import uteq.appdist.apipaises.soapws.shared.ServiceResponse;

@Endpoint
public class UserEndpoint {
    
    private static final String NAMESPACE_URI = "http://user.interfaces.generated.soapws.apipaises.appdist.uteq";


    private UserService userService;

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "registerUserRequest")
    @ResponsePayload
    public RegisterUserResponse saveUser(@RequestPayload RegisterUserRequest request) {
        RegisterUserResponse response = new RegisterUserResponse();
        ServiceResponse serviceResponse;

        UserResponse target = new UserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        uteq.appdist.apipaises.soapws.entities.users.User useryLocalModel = new uteq.appdist.apipaises.soapws.entities.users.User();
        BeanUtils.copyProperties(request.getUser(), useryLocalModel);

        serviceResponse = userService.saveUser(request);

        if (serviceResponse.getStatus() == -1) {
            serviceStatus.setStatus("ERROR");
            target = null;
        } else {
            serviceStatus.setStatus("SUCCESS");
            useryLocalModel.setUserid(serviceResponse.getIdentif());
            BeanUtils.copyProperties(useryLocalModel, target);
        }

        serviceStatus.setMessage(serviceResponse.getAdditionalMessage());

        response.setUser(target);
        response.setServiceStatus(serviceStatus);

        return response;
    }


}

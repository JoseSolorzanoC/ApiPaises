package uteq.appdist.apipaises.soapws.entities.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.appdist.apipaises.soapws.generated.interfaces.user.RegisterUserRequest;
import uteq.appdist.apipaises.soapws.generated.interfaces.user.UserRequest;
import uteq.appdist.apipaises.soapws.shared.DBResponse;
import uteq.appdist.apipaises.soapws.shared.ServiceResponse;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ServiceResponse saveUser(RegisterUserRequest user) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus(-1);

        DBResponse dbResponse;

        // Validación de que el correo no se repita
        if (userRepository.getUserByEmail(user.getUser().getEmail()).size() > 0) {
            serviceResponse.setAdditionalMessage("El Correo ya está en uso.");
            return serviceResponse;
        }

        // Validación de que el telefono no se repita
        if (userRepository.getUserByPhone(user.getUser().getPhone()).size() > 0) {
            serviceResponse.setAdditionalMessage("El telefono ya está en uso.");
            return serviceResponse;
        }

        // Validación de que el telefono no se repita
        if (userRepository.getUserByUserName(user.getUser().getUserName()).size() > 0) {
            serviceResponse.setAdditionalMessage("El nombre de usuario ya está en uso.");
            return serviceResponse;
        }

        try {
            dbResponse = userRepository.saveUser(user.getUser().getFirstName(),
                    user.getUser().getSecondName(), user.getUser().getEmail(),user.getUser().getPhone(),user.getUser().getUserName(),user.getUser().getPassword());

        } catch (Exception e) {
            serviceResponse
                    .setAdditionalMessage(
                            String.format("Error al realizar el registro. Error Message => %s", e.getMessage()));
            return serviceResponse;
        }

        if (dbResponse.getStatus() != 2) {
            serviceResponse
                    .setAdditionalMessage(
                            "Ocurrió un error inesperado al intentar registrar la provincia. Inténtelo nuevamente más tarde");
            return serviceResponse;
        }

        serviceResponse.setIdentif(dbResponse.getIdentif());
        serviceResponse.setStatus(0);
        serviceResponse.setAdditionalMessage("Registro exitoso");

        return serviceResponse;
    }

}

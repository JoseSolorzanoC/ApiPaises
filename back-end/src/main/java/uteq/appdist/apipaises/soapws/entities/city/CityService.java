package uteq.appdist.apipaises.soapws.entities.city;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.appdist.apipaises.soapws.shared.DBResponse;
import uteq.appdist.apipaises.soapws.shared.ServiceResponse;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCitiesFromProvince(int provinceId) {
        return cityRepository.getAllCitiesFromProvince(provinceId);
    }

    public Optional<City> getCityById(int id) {
        return cityRepository.getCityById(id);
    }

    public ServiceResponse saveCity(City city) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus(-1);
        DBResponse dbResponse;

        // Validación de que no exista una ciudad con el nombre a registrar
        if (cityRepository.getCityByName(city.getCityName(), 0, city.getCityProvinceId()).isPresent()) {
            serviceResponse.setAdditionalMessage("Ya existe una ciudad con el nombre ingresado en la pronvincia.");
            return serviceResponse;
        }

        // Validación de que no exista una ciudad con el código de llamada a registrar
        if (cityRepository.getCityByCallCode(city.getCityCallCode(), 0, city.getCityProvinceId()).isPresent()) {
            serviceResponse
                    .setAdditionalMessage("Ya existe una ciudad con el código de llamada ingresado en la provincia.");
            return serviceResponse;
        }

        try {
            dbResponse = cityRepository.saveCity(city.getCityName(),
                    city.getCityFlag(),
                    city.getCityCabecera(),
                    city.getCityAlt(),
                    city.getCityLat(),
                    city.getCityState(),
                    city.getCityCallCode(),
                    city.getCityProvinceId());
        } catch (Exception e) {
            serviceResponse
                    .setAdditionalMessage(
                            String.format("Error al realizar el registro. Error Message => %s", e.getMessage()));
            return serviceResponse;
        }

        if (dbResponse.getStatus() != 2) {
            serviceResponse
                    .setAdditionalMessage(
                            "Ocurrió un error inesperado al intentar registrar la ciudad. Inténtelo nuevamente más tarde");
            return serviceResponse;
        }

        serviceResponse.setIdentif(dbResponse.getIdentif());
        serviceResponse.setStatus(0);
        serviceResponse.setAdditionalMessage("Registro exitoso");

        return serviceResponse;
    }

    public ServiceResponse updateCity(City city) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus(-1);
        DBResponse dbResponse;

        // Validación de que no exista una ciudad con el nombre a registrar
        if (cityRepository.getCityByName(city.getCityName(), city.getCityId(), city.getCityProvinceId()).isPresent()) {
            serviceResponse.setAdditionalMessage("Ya existe una ciudad con el nombre ingresado en la pronvincia.");
            return serviceResponse;
        }

        // Validación de que no exista una ciudad con el código de llamada a registrar
        if (cityRepository.getCityByCallCode(city.getCityCallCode(), city.getCityId(), city.getCityProvinceId())
                .isPresent()) {
            serviceResponse
                    .setAdditionalMessage("Ya existe una ciudad con el código de llamada ingresado en la provincia.");
            return serviceResponse;
        }

        try {
            dbResponse = cityRepository.updateCity(city.getCityId(),
                    city.getCityName(),
                    city.getCityFlag(),
                    city.getCityCabecera(),
                    city.getCityAlt(),
                    city.getCityLat(),
                    city.getCityState(),
                    city.getCityCallCode(),
                    city.getCityProvinceId());
        } catch (Exception e) {
            serviceResponse
                    .setAdditionalMessage(
                            String.format("Error al realizar la actualización. Error Message => %s", e.getMessage()));
            return serviceResponse;
        }

        if (dbResponse.getStatus() != 2) {
            serviceResponse
                    .setAdditionalMessage(
                            "Ocurrió un error inesperado al intentar actualizar la ciudad. Inténtelo nuevamente más tarde");
            return serviceResponse;
        }

        serviceResponse.setIdentif(dbResponse.getIdentif());
        serviceResponse.setStatus(0);
        serviceResponse.setAdditionalMessage("Actualización exitosa");

        return serviceResponse;
    }

    public ServiceResponse changeStatusCity(int cityId, String state) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus(-1);

        DBResponse dbResponse;

        // Get one city
        Optional<City> city = cityRepository.getCityById(cityId);
        // Validación de que la ciudad a actualizar exista.
        if (!city.isPresent()) {
            serviceResponse.setAdditionalMessage("El identificador ingresado no corresponde a ningúna ciudad.");
            return serviceResponse;
        }

        try {

            dbResponse = cityRepository.updateCity(city.get().getCityId(),
                    city.get().getCityName(), city.get().getCityFlag(), city.get().getCityCabecera(),
                    city.get().getCityAlt(),
                    city.get().getCityLat(), state, city.get().getCityCallCode(),
                    city.get().getCityProvinceId());
        } catch (Exception e) {
            serviceResponse
                    .setAdditionalMessage(
                            String.format("Error al realizar el cambio. Error Message => %s", e.getMessage()));
            return serviceResponse;
        }

        if (dbResponse.getStatus() != 2) {
            serviceResponse
                    .setAdditionalMessage(
                            "Ocurrió un error inesperado al intentar cambiar el estado de la ciudad. Inténtelo nuevamente más tarde.");
            return serviceResponse;
        }

        serviceResponse.setIdentif(dbResponse.getIdentif());
        serviceResponse.setStatus(0);
        serviceResponse.setAdditionalMessage("Actualización del estado de la ciudad exitoso.");

        return serviceResponse;
    }
}

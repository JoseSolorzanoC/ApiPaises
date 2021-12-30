package uteq.appdist.apipaises.soapws.entities.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.appdist.apipaises.soapws.shared.DBResponse;
import uteq.appdist.apipaises.soapws.shared.ServiceResponse;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.getAllCountries();
    }

    public Optional<Country> getCountryById(int id) {
        return countryRepository.getCountryById(id);
    }

    public Optional<Country> getCountryByIso2(String iso2) {
        return countryRepository.getCountryByIso2(iso2);
    }

    public ServiceResponse saveCountry(Country country) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus(-1);
        DBResponse dbResponse;

        // Validación de que no exista un país con el nombre a registrar
        if (countryRepository.getCountryByName(country.getCountryName(), 0).isPresent()) {
            serviceResponse.setAdditionalMessage("Ya existe un país con el nombre ingresado");
            return serviceResponse;
        }

        // Validación de que no exista un país con el código de llamada a registrar
        if (countryRepository.getCountryByCallCode(country.getCountryCallCode(), 0).isPresent()) {
            serviceResponse.setAdditionalMessage("Ya existe un país con el código de llamada ingresado");
            return serviceResponse;
        }

        // Validación de que no exista un país con alguno de los códigos de pais a
        // ingresar
        if (countryRepository.getCountryByCodes(country.getCountryTld(), country.getCountryIso3(),
                country.getCountryIso2(), country.getCountryFips(), country.getCountryIson(), 0) > 0) {
            serviceResponse
                    .setAdditionalMessage("Ya existe un país asociado a alguno de los códigos de país ingresados");
            return serviceResponse;
        }

        try {
            dbResponse = countryRepository.saveCountry(country.countryName,
                    country.countryFlag, country.countryCapital, country.countryAlt, country.countryLat,
                    country.countryState, country.countryCallCode,
                    country.countryTld, country.countryIso3, country.countryIso2, country.countryFips,
                    country.countryIson,
                    country.countryEnglishName);
        } catch (Exception e) {
            serviceResponse
                    .setAdditionalMessage(
                            String.format("Error al realizar el registro. Error Message => %s", e.getMessage()));
            return serviceResponse;
        }

        if (dbResponse.getStatus() != 2) {
            serviceResponse
                    .setAdditionalMessage(
                            "Ocurrió un error inesperado al intentar registrar el país. Inténtelo nuevamente más tarde");
            return serviceResponse;
        }

        serviceResponse.setIdentif(dbResponse.getIdentif());
        serviceResponse.setStatus(0);
        serviceResponse.setAdditionalMessage("Registro exitoso");

        return serviceResponse;
    }

    public ServiceResponse updateCountry(Country country) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus(-1);
        DBResponse dbResponse;

        // Validación de que no exista un país con el nombre a registrar
        if (countryRepository.getCountryByName(country.getCountryName(), country.getCountryId()).isPresent()) {
            serviceResponse.setAdditionalMessage("Ya existe un país con el nombre ingresado");
            return serviceResponse;
        }

        // Validación de que no exista un país con el código de llamada a registrar
        if (countryRepository.getCountryByCallCode(country.getCountryCallCode(), country.getCountryId()).isPresent()) {
            serviceResponse.setAdditionalMessage("Ya existe un país con el código de llamada ingresado");
            return serviceResponse;
        }

        // Validación de que no exista un país con alguno de los códigos de pais a
        // ingresar
        if (countryRepository.getCountryByCodes(country.getCountryTld(), country.getCountryIso3(),
                country.getCountryIso2(), country.getCountryFips(), country.getCountryIson(),
                country.getCountryId()) > 0) {
            serviceResponse
                    .setAdditionalMessage("Ya existe un país asociado a alguno de los códigos de país ingresados");
            return serviceResponse;
        }

        try {
            dbResponse = countryRepository.updateCountry(country.countryId, country.countryName,
                    country.countryFlag, country.countryCapital, country.countryAlt, country.countryLat,
                    country.countryState, country.countryCallCode,
                    country.countryTld, country.countryIso3, country.countryIso2, country.countryFips,
                    country.countryIson,
                    country.countryEnglishName);
        } catch (Exception e) {
            serviceResponse
                    .setAdditionalMessage(
                            String.format("Error al realizar la actualización. Error Message => %s", e.getMessage()));
            return serviceResponse;
        }

        if (dbResponse.getStatus() != 2) {
            serviceResponse
                    .setAdditionalMessage(
                            "Ocurrió un error inesperado al intentar actualizar el país. Inténtelo nuevamente más tarde");
            return serviceResponse;
        }

        serviceResponse.setIdentif(dbResponse.getIdentif());
        serviceResponse.setStatus(0);
        serviceResponse.setAdditionalMessage("Actualización exitosa");

        return serviceResponse;
    }
}

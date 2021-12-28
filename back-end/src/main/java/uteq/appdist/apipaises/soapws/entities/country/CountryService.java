package uteq.appdist.apipaises.soapws.entities.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uteq.appdist.apipaises.soapws.shared.DBResponse;

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

    public DBResponse saveCountry(Country country) {
        return countryRepository.saveCountry(country.countryName,
                country.countryFlag, country.countryCapital, country.countryAlt, country.countryLat,
                country.countryState, country.countryCallCode,
                country.countryTld, country.countryIso3, country.countryIso2, country.countryFips, country.countryIson,
                country.countryEnglishName);
    }
}

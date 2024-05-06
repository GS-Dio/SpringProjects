package io.sanzharss.relationship.service.one_to_one.unidirectional;


import io.sanzharss.relationship.domain.one_to_one.unidirectional.Capital;
import io.sanzharss.relationship.domain.one_to_one.unidirectional.Country;
import io.sanzharss.relationship.repository.one_to_one.unidirectionalRepository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CountryService {
    @Autowired
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public Country save(Country country){
        return countryRepository.save(country);
    }

    public Country update(Long id, Country country){
        Optional<Country> optionalCountry = countryRepository.findById(id);

        if (optionalCountry.isPresent()){
            Country myCountry = optionalCountry.get();

            myCountry.setName(country.getName());
            myCountry.setCapital(country.getCapital());

            return myCountry;
        }else
            log.warn("Country " + id + " not found!");

        return null;
    }

    public List<Country> findAll(){
        List<Country> countries = new LinkedList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    public Country findById(Long id){
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()){
            return optionalCountry.get();
        }else
            log.warn("Country " + id + " not found!");
        return null;
    }

    public void delete(Long id){
        countryRepository.deleteById(id);
    }

}

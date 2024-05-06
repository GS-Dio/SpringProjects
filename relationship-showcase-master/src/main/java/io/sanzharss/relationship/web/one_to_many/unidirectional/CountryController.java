package io.sanzharss.relationship.web.one_to_many.unidirectional;

import io.sanzharss.relationship.domain.one_to_one.unidirectional.Country;
import io.sanzharss.relationship.service.one_to_one.unidirectional.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public Country save(@RequestBody Country country){
        return countryService.save(country);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable Long id, Country country){
        return countryService.update(id, country);
    }

    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Country findById(@PathVariable Long id){
        return countryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        countryService.delete(id);
    }
}

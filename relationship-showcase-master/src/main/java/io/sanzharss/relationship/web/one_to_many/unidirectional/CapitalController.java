package io.sanzharss.relationship.web.one_to_many.unidirectional;

import io.sanzharss.relationship.domain.one_to_one.unidirectional.Capital;
import io.sanzharss.relationship.service.one_to_one.unidirectional.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capital")
public class CapitalController {
    @Autowired
    public final CapitalService capitalService;

    public CapitalController(CapitalService capitalService) {
        this.capitalService = capitalService;
    }
    
    @PostMapping
    public Capital save(@RequestBody Capital capital){
        return capitalService.save(capital);
    } 
    
    @PutMapping("/{id}")
    public Capital update(@PathVariable Long id, @RequestBody Capital capital){
        return capitalService.update(id, capital);
    }

    @GetMapping
    public List<Capital> findAll(){
        return capitalService.findAll();
    }

    @GetMapping("/{id}")
    public Capital findById(@PathVariable Long id){
        return capitalService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        capitalService.delete(id);
    }
}

package io.sanzharss.relationship.service.one_to_one.unidirectional;

import io.sanzharss.relationship.domain.one_to_one.unidirectional.Capital;
import io.sanzharss.relationship.repository.one_to_one.unidirectionalRepository.CapitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CapitalService {
    @Autowired
    private final CapitalRepository capitalRepository;

    public CapitalService(CapitalRepository capitalRepository) {
        this.capitalRepository = capitalRepository;
    }

    public Capital save(Capital capital){
        return capitalRepository.save(capital);
    }

    public Capital update(Long id,Capital capital){
        Optional<Capital> optionalCapital = capitalRepository.findById(id);

        if (optionalCapital.isPresent()){
            Capital myCapital = optionalCapital.get();

            myCapital.setName(capital.getName());

            return myCapital;
        }else
            log.warn("Capital " + id + " not found!");
        return null;
    }

    public Capital findById(Long id){
        Optional<Capital> optionalCapital = capitalRepository.findById(id);
        if (optionalCapital.isPresent()){
            return optionalCapital.get();
        }else
            log.warn("Capital " + id + " not found!");
        return null;
    }

    public List<Capital> findAll(){
        List<Capital> capitals = new LinkedList<>();
        capitalRepository.findAll().forEach(capitals::add);
        return capitals;
    }

    public void delete(Long id){
        capitalRepository.deleteById(id);
    }
}

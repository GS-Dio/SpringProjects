package io.sanzharss.relationship.web.one_to_many.bidirectional;

import io.sanzharss.relationship.domain.one_to_one.bidirectional.Fingerprint;
import io.sanzharss.relationship.service.one_to_one.bidirectional.FingerprintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fingerprint")
public class FingerprintController {

    private final FingerprintService fingerprintService;

    public FingerprintController(FingerprintService fingerprintService) {
        this.fingerprintService = fingerprintService;
    }

    @PostMapping
    public Fingerprint save(@RequestBody Fingerprint fingerprint){
        return fingerprintService.save(fingerprint);
    }

    @PutMapping("/{id}")
    public Fingerprint update(@PathVariable Long id, Fingerprint fingerprint){
        return fingerprintService.update(id, fingerprint);
    }

    @GetMapping
    public List<Fingerprint> findAll(){
        return fingerprintService.findAll();
    }

    @GetMapping("/{id}")
    public Fingerprint findById(@PathVariable Long id){
        return fingerprintService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        fingerprintService.delete(id);
    }
}

package io.sanzharss.relationship.service.one_to_one.bidirectional;

import io.sanzharss.relationship.domain.one_to_one.bidirectional.Fingerprint;
import io.sanzharss.relationship.repository.one_to_one.bidirectionalRepository.FingerprintRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FingerprintService {
    @Autowired
    private final FingerprintRepository fingerprintRepository;

    public FingerprintService(FingerprintRepository fingerprintRepository) {
        this.fingerprintRepository = fingerprintRepository;
    }

    public Fingerprint save(Fingerprint fingerprint){
        return fingerprintRepository.save(fingerprint);
    }

    public Fingerprint update(Long id, Fingerprint updateFingerprint){
        Optional<Fingerprint> optionalFingerprint = fingerprintRepository.findById(id);

        if (optionalFingerprint.isPresent()){
            Fingerprint myFingerprint = optionalFingerprint.get();

            myFingerprint.setPerson(updateFingerprint.getPerson());
            myFingerprint.setTexture(updateFingerprint.getTexture());

            return  myFingerprint;
        }else
            log.warn("Fingerprint " + id + "not found!");

        return null;
    }

    public Fingerprint findById(Long id){
        Optional<Fingerprint> optionalFingerprint = fingerprintRepository.findById(id);

        if (optionalFingerprint.isPresent()){
            return  optionalFingerprint.get();
        }else
            log.warn("Fingerprint " + id + "not found!");

        return null;
    }

    public List<Fingerprint> findAll(){
        List<Fingerprint> fingerprints = new LinkedList<>();
        fingerprintRepository.findAll().forEach(fingerprints::add);
        return fingerprints;
    }

    public void delete(Long id){
        fingerprintRepository.deleteById(id);
    }
}

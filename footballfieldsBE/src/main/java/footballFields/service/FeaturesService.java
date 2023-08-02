package footballFields.service;

import footballFields.entities.FeaturesEntity;
import footballFields.repository.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeaturesService {
    @Autowired
    private FeaturesRepository featuresRepository;


    public List<FeaturesEntity> getAllFeatures() {
        return featuresRepository.findAll();
    }

    public Optional<FeaturesEntity> getFeaturesById(Long id) {
        return featuresRepository.findById(id);
    }

    public FeaturesEntity saveFeatures(FeaturesEntity feature) {
        return featuresRepository.save(feature);
    }

    public FeaturesEntity updateFeatures(FeaturesEntity feature) {
        if(feature == null) throw new NullPointerException("Compilare tutti i campi");

        Optional<FeaturesEntity> featureEntity = getFeaturesById(Long.valueOf(feature.getId()));

        if(featureEntity.isEmpty()) throw new NullPointerException();
        return featuresRepository.save(feature);
    }

    public void deleteFeature(Long id) {
        featuresRepository.deleteById(id);
    }
}

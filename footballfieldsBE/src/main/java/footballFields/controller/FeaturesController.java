package footballFields.controller;

import footballFields.entities.AssociateEntity;
import footballFields.entities.FeaturesEntity;
import footballFields.service.AssociateService;
import footballFields.service.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footballfields/features")
public class FeaturesController {

    @Autowired
    private FeaturesService featuresService;

    @GetMapping("/get-allFeatures")
    public List<FeaturesEntity> getFeatures(){
        return featuresService.getAllFeatures();
    }

    @GetMapping("/get-by-id/{id}")
    public FeaturesEntity getFeaturesById(@PathVariable Long id){
        return featuresService.getFeaturesById(id).get();
    }

    @PostMapping("/save")
    public FeaturesEntity saveFeatures(@RequestBody FeaturesEntity feature){
        return featuresService.saveFeatures(feature);
    }

    @PutMapping("/update")
    public FeaturesEntity updateFeatures(@RequestBody FeaturesEntity feature){
        return featuresService.updateFeatures(feature);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFeature(@PathVariable Long id){

        featuresService.deleteFeature(id);
    }





}

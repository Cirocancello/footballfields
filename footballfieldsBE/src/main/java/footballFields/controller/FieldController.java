package footballFields.controller;

import footballFields.entities.AssociateEntity;
import footballFields.entities.FieldEntity;
import footballFields.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footballfields/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping("/get-allField")
    public List<FieldEntity> getFields(){

        return fieldService.getAllFields();
    }


    @GetMapping("/get-by-id/{id}")
    public FieldEntity getFieldById(@PathVariable Long id){
        return fieldService.getFieldById(id).get();
    }

    @PostMapping("/save")
    public FieldEntity saveField(@RequestBody FieldEntity field){
        return fieldService.saveField(field);
    }

    @PutMapping("/update")
    public FieldEntity updateField(@RequestBody FieldEntity field){
        return fieldService.updateField(field);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteField(@PathVariable Long id){
        fieldService.deleteField(id);
    }



}

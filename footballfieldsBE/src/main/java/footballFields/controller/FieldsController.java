package footballFields.controller;


import footballFields.entities.AssociateEntity;
import footballFields.entities.FieldsEntity;
import footballFields.service.FieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footballsfields/fields")
public class FieldsController {

        @Autowired
        private FieldsService fieldsService;

        @GetMapping("/get-allAssociate")
        public List<FieldsEntity> getAllAssociate() {
                return fieldsService.getAllFields();
        }


        @GetMapping("/get-by-id/{id}")
        public FieldsEntity getFieldsById(@PathVariable Long id) {
                return fieldsService.getFieldsById(id).get();
        }


        @PostMapping("/save")
        public FieldsEntity saveFields(@RequestBody FieldsEntity fields){
                return fieldsService.saveFields(fields);
        }

        @PutMapping("/update")
        public FieldsEntity updateFields(@RequestBody FieldsEntity fields){
                return fieldsService.updateFields(fields);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteFields(@PathVariable Long id){

                fieldsService.deleteFields(id);
        }

        //custom
        @GetMapping("/fields-by-nome/{nome}")
        public List<String> getFieldsByNome(@PathVariable String nome){
                return fieldsService.getFieldsByNome(nome);
        }

}
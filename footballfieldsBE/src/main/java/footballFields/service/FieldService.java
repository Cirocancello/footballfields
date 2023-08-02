package footballFields.service;


import footballFields.entities.FieldEntity;
import footballFields.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {
    @Autowired
    public FieldRepository fieldRepository;

    public List<FieldEntity> getAllFields() {

        return fieldRepository.findAll();
    }

    public Optional<FieldEntity> getFieldById(Long id) {

        return fieldRepository.findById(id);
    }

    public FieldEntity saveField(FieldEntity field) {

        return  fieldRepository.save(field);
    }

    public FieldEntity updateField(FieldEntity field) {
       if(field == null) throw new NullPointerException("Compilare tutti i campi");

            Optional<FieldEntity> fieldEntity = getFieldById(field.getId());

            if(fieldEntity.isEmpty()) throw new NullPointerException();
            return fieldRepository.save(field);
        }

    public void deleteField(Long id) {
        fieldRepository.deleteById(id);
    }



}


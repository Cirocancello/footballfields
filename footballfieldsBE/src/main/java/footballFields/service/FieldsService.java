package footballFields.service;

import footballFields.entities.FieldsEntity;
import footballFields.repository.FieldsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldsService {
    @Autowired
    private FieldsRepository fieldsRepository;


    public List<FieldsEntity> getAllFields() {
        return fieldsRepository.findAll();
    }

    public Optional<FieldsEntity> getFieldsById(Long id) {

        return fieldsRepository.findById(id);
    }

    public FieldsEntity saveFields(FieldsEntity fields) {
        return fieldsRepository.save(fields);
    }


    public FieldsEntity updateFields(FieldsEntity fields) {
        if(fields == null) throw new NullPointerException("Compilare tutti i campi");

        Optional<FieldsEntity> fieldsEntity = getFieldsById(fields.getId());

        if(fieldsEntity.isEmpty()) throw new NullPointerException();
        return fieldsRepository.save(fields);
    }

    public void deleteFields(Long id) {
        fieldsRepository.deleteById(id);
    }

    public List<String> getFieldsByNome(String nome) {
        return fieldsRepository.getFieldsByNome(nome);
    }
}

package footballFields.service;

import footballFields.entities.AssociateEntity;
import footballFields.repository.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociateService {
    @Autowired
    private AssociateRepository associateRepository;

    public List<AssociateEntity> getAllAssociate() {

        return associateRepository.findAll();
    }

    public Optional<AssociateEntity> getAssociateById(Long id) {

        return associateRepository.findById(id);
    }

    public AssociateEntity saveAssociate(AssociateEntity entity) {

        return associateRepository.save(entity);
    }

    public AssociateEntity updateAssociate(AssociateEntity associateNew) {
        if(associateNew == null) throw new NullPointerException("Compilare tutti i campi");

        Optional<AssociateEntity> associateEntity = getAssociateById(associateNew.getId());

        if(associateEntity.isEmpty()) throw new NullPointerException();
        return associateRepository.save(associateNew);
    }

    public void deleteAssociate(Long id) {
        associateRepository.deleteById(id);
    }

    public List<String> getAssociateByCognome(String iniziale) {
        return associateRepository.getAssociateByCognome(iniziale);
    }



    //TODO fare query con dto
}

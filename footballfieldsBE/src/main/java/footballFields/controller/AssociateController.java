package footballFields.controller;

import footballFields.entities.AssociateEntity;
import footballFields.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associate")
public class AssociateController {

  @Autowired
  private AssociateService associateService;

        @GetMapping("/get-allAssociate")
        public List<AssociateEntity> getAllAssociate(){
                return associateService.getAllAssociate();
        }

        @GetMapping("/get-by-id/{id}")
        public AssociateEntity getAssociateById(@PathVariable Long id){
                return associateService.getAssociateById(id).get();
        }

        @PostMapping("/save")
        public AssociateEntity saveAssociate(@RequestBody AssociateEntity associate){
                return associateService.saveAssociate(associate);
        }

        @PutMapping("/update")
        public AssociateEntity updateAssociate(@RequestBody AssociateEntity associate){
                return associateService.updateAssociate(associate);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteAssociate(@PathVariable Long id){

            associateService.deleteAssociate(id);
        }

        //custom
        @GetMapping("/associate-by-cognome/{iniziale}")
        public List<String> getAssociateByCognome(@PathVariable String iniziale){
                return associateService.getAssociateByCognome(iniziale);
        }

    //TODO fare query con dto
//        @GetMapping("/autori-by-cognome-dto/{iniziale}")
//        public List<AutoreDTO> getAutoreByCognomeConDto(@PathVariable String iniziale){
//                return autoreService.getAutoreByCognomeConDto(iniziale);
//        }
//


}

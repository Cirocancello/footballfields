package footballFields.repository;


import footballFields.entities.AssociateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssociateRepository extends JpaRepository<AssociateEntity, Long> {

    @Query(value = "SELECT * " +
            "FROM associate " , nativeQuery = true)
    List<AssociateEntity> getAllAssociate();

    @Query(value = "SELECT fist " +
            "FROM associate " +
            "WHERE last LIKE :iniziale% ", nativeQuery = true)
    List<String> getAssociateByCognome(@Param("iniziale") String iniziale);

    //TODO fare le query con DTO

}

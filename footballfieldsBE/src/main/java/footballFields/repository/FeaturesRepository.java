package footballFields.repository;

import footballFields.entities.AssociateEntity;
import footballFields.entities.FeaturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeaturesRepository extends JpaRepository<FeaturesEntity, Long> {

    @Query(value = "SELECT * " +
            "FROM associate " , nativeQuery = true)
    List<AssociateEntity> getAllAssociate();

    @Query(value = "SELECT fist " +
            "FROM associate " +
            "WHERE last LIKE :iniziale% ", nativeQuery = true)
    List<String> getFeaturesById(@Param("iniziale") String iniziale);
}

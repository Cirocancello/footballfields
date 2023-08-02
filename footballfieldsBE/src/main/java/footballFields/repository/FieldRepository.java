package footballFields.repository;

import footballFields.entities.FieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FieldRepository extends JpaRepository<FieldEntity, Long> {

    @Query(value = "SELECT * " +
            "FROM field " , nativeQuery = true)
    List<FieldEntity> getAllFields();

}

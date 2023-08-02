package footballFields.repository;

import footballFields.entities.AssociateEntity;
import footballFields.entities.FieldsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FieldsRepository extends JpaRepository<FieldsEntity, Long> {


    @Query(value = "SELECT * " +
            "FROM associate " , nativeQuery = true)
    List<AssociateEntity> getAllAssociate();

    @Query(value = "SELECT * " +
            "FROM fields " +
            "WHERE last LIKE :nome ", nativeQuery = true)
    List<String> getFieldsByNome(@Param("nome") String nome);



}

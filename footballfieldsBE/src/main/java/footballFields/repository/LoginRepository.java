package footballFields.repository;

import footballFields.entities.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {


    @Query(value = "SELECT * " +
            "FROM login " , nativeQuery = true)
    List<LoginEntity> getAllLogin();


    @Query(value = "SELECT user_name " +
            "FROM login " +
            "WHERE last LIKE :userName ", nativeQuery = true)
    List<String> getLoginByUserName(@Param("userName") String userName);

}

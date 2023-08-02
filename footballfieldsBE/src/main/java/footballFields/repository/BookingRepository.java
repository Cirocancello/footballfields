package footballFields.repository;

import footballFields.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query(value = "SELECT * " +
                   "FROM booking " , nativeQuery = true)
    List<BookingEntity> getAllBooking();


    @Query(value = "SELECT * " +
            "FROM booking " +
            "WHERE last LIKE :time ", nativeQuery = true)
    List<String> getBookingByTime(@Param("time") String time);
}

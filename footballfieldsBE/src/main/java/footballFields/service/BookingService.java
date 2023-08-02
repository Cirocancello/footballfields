package footballFields.service;

import footballFields.entities.BookingEntity;
import footballFields.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    public List<BookingEntity> getAllBooking() {
        return bookingRepository.findAll();
    }

    public Optional<BookingEntity> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public BookingEntity bookingEntity(BookingEntity booking) {
        return bookingRepository.save(booking);
    }

    public BookingEntity uddateBooking(BookingEntity booking) {
        if(booking == null) throw new NullPointerException("Compilare tutti i campi");

        Optional<BookingEntity> bookingEntity = getBookingById(booking.getId());

        if(bookingEntity.isEmpty()) throw new NullPointerException();
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<String> getBookingByTime(String time) {
        return bookingRepository.getBookingByTime(time);
    }


}

package footballFields.controller;

import footballFields.entities.BookingEntity;
import footballFields.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footballfields/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/get-allBooking")
    public List<BookingEntity> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @GetMapping("/get-by-id/{id}")
    public BookingEntity getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id).get();
    }

    @PostMapping("/save")
    public BookingEntity bookingEntity(@RequestBody BookingEntity booking){
        return bookingService.bookingEntity(booking);
    }

    @PutMapping("/update")
    public BookingEntity updateBooking(@RequestBody BookingEntity booking){
        return bookingService.uddateBooking(booking);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
    }

    //custom
    @GetMapping("/booking-by-time/{time}")
    public List<String> getBookingByTime(@PathVariable String time){
        return bookingService.getBookingByTime(time);
    }


}

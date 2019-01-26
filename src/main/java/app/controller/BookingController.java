package app.controller;

import app.model.BookingModel;
import app.model.CheckToken;
import app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/booking/v1")
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/request")
    public BookingModel bookStylist(@RequestBody BookingModel bookingModel) {
        return this.bookingService.save(bookingModel);
    }

    @GetMapping("/bookings")
    public List<BookingModel> getBookingLists() {
        return this.bookingService.getAllBookings();
    }

    @GetMapping("/bookings/{status}")
    public Iterable<BookingModel> findByStatus(@PathVariable String status) {
        Optional<Iterable<BookingModel>> bookingList = this.bookingService.findByStatus(status);
        if(bookingList.isPresent()) {
            return bookingList.get();
        }

        return null;
    }

    @PostMapping("/check-booking")
    @ResponseBody
    public Iterable<BookingModel> findAllByStylistEmail(@RequestBody CheckToken token){
        Optional<Iterable<BookingModel>> booking = bookingService.findAllByStylistEmail(token.stylistEmail);
        if(booking.isPresent()) {
            return booking.get();
        }

        return null;
    }

    @PutMapping("/completed-requests/{id}/{accepted}")
    public BookingModel updateStatus(@PathVariable("id") String id, @PathVariable("accepted") boolean accepted) {
        Optional<BookingModel> existBooking = this.bookingService.findById(id);
        if(existBooking.isPresent()) {
//            updatedBooking = existBooking.get();
            if(accepted) {
//                updatedBooking.setStatus("accepted");
                existBooking.get().setStatus("accepted");
            }
            else {
//                updatedBooking.setStatus("rejected");
                existBooking.get().setStatus("rejected");
            }
//            BeanUtils.copyProperties(updatedBooking, existBooking);
            this.bookingService.save(existBooking.get());
            return existBooking.get();
        }

        return null;

    }

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}

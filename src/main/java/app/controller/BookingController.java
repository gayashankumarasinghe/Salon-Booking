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

    @PostMapping("/confirm-booking")
    public boolean bookStylist(@RequestBody BookingModel bookingModel) {
    	bookingModel.setStatus("pending");
    	try {
    		this.bookingService.save(bookingModel);
    		return true;
    	}catch(Error e) {
    		return false;
    	}
        
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
    
    @PostMapping("/check-status")
    @ResponseBody
    public Iterable<BookingModel> findAllBySalonEmail(@RequestBody CheckToken token){
        Optional<Iterable<BookingModel>> booking = bookingService.findAllBySalonEmail(token.salonEmail);
        if(booking.isPresent()) {
            return booking.get();
        }

        return null;
    }
    

    @PostMapping("/response-booking")
    @ResponseBody
    public boolean updateStatus(@RequestBody CheckToken token) {
        Optional<BookingModel> existBooking = this.bookingService.findById(token.bookingId);
        if(existBooking.isPresent()) {
//            updatedBooking = existBooking.get();
            if(token.status == "accept") {
//                updatedBooking.setStatus("accepted");
                existBooking.get().setStatus(token.status);
            }
            else {
//                updatedBooking.setStatus("rejected");
                existBooking.get().setStatus(token.status);
            }
//            BeanUtils.copyProperties(updatedBooking, existBooking);
            this.bookingService.save(existBooking.get());
            return true;
        }

        return false;

    }

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}

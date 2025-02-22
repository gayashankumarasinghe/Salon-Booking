package app.service;

import app.model.BookingModel;
import app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookingServiceImpl")
public class BookingServiceImpl implements BookingService{

    private BookingRepository bookingRepository;

    @Override
    public BookingModel save(BookingModel bookingModel) {
        return this.bookingRepository.save(bookingModel);
    }

    @Override
    public List<BookingModel> getAllBookings() {
        return this.bookingRepository.findAll();
    }

    @Override
    public Optional<Iterable<BookingModel>> findByStatus(String status) {
        return this.bookingRepository.findByStatus(status);
    }

    @Override
    public Optional<BookingModel> findById(String id) {
        return this.bookingRepository.findById(id);
    }

    @Override
    public Optional<Iterable<BookingModel>> findAllByStylistEmail(String stylistEmail) {
        return this.bookingRepository.findAllByStylistEmail(stylistEmail);
    }

    @Autowired
    public void setBookingRepository(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

	@Override
	public Optional<Iterable<BookingModel>> findAllBySalonEmail(String salonEmail) {
		return this.bookingRepository.findAllBySalonEmail(salonEmail);
	}
}

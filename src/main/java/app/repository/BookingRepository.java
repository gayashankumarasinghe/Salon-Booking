package app.repository;

import app.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<BookingModel, String> {
    Optional<Iterable<BookingModel>> findByStatus(String status);

    Optional<Iterable<BookingModel>> findAllByStylistEmail(String stylistEmail);

	Optional<Iterable<BookingModel>> findAllBySalonEmail(String salonEmail);
}

package app.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="book")
public class BookingModel {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "SalonId")
    private String salonId;
    @Column(name = "StylistId")
    private String stylistId;
    @Column(name = "BookingDate")
    private String bookingDate;
    @Column(name = "Status")
    private String status;
    @Column(name = "SalonEmail")
    private String salonEmail;
    @Column(name = "StylistEmail")
    private String stylistEmail;

    public BookingModel() {
    }

    public BookingModel(String id, String salonId, String stylistId, String bookingDate, String status, String salonEmail, String stylistEmail) {
        this.id = id;
        this.salonId = salonId;
        this.stylistId = stylistId;
        this.bookingDate = bookingDate;
        this.status = status;
        this.salonEmail = salonEmail;
        this.stylistEmail = stylistEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }

    public String getStylistId() {
        return stylistId;
    }

    public void setStylistId(String stylistId) {
        this.stylistId = stylistId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalonEmail() {
        return salonEmail;
    }

    public void setSalonEmail(String salonEmail) {
        this.salonEmail = salonEmail;
    }

    public String getStylistEmail() {
        return stylistEmail;
    }

    public void setStylistEmail(String stylistEmail) {
        this.stylistEmail = stylistEmail;
    }
}


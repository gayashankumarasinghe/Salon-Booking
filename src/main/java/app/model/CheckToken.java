package app.model;

public class CheckToken {
	public String stylistEmail;
	public String salonEmail;
	public String salonName;
	public String salonCity;
	public String salonStreet;
	public String salonWebsite;
	public String bookingId;
    public String date;
    public String status;


    public CheckToken(String stylistEmail, String salonEmail, String salonName, String salonCity, String salonStreet, String salonWebsite, String bookingId, String date, String status) {
    	this.stylistEmail = stylistEmail;
    	this.salonEmail = salonEmail;
    	this.salonName = salonName;
    	this.salonCity = salonCity;
    	this.salonStreet = salonStreet;
    	this.salonWebsite = salonWebsite;
    	this.bookingId = bookingId;
    	this.date = date;
    	this.status = status;
    }

    public CheckToken() {

    }
    
	
}

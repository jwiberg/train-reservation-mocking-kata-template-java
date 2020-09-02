package kata.trainreservation.service;

import kong.unirest.Unirest;

public class BookingReferenceService {

	private String url;

	public BookingReferenceService(String url) {
		this.url = url;
	}

	public String createReference() {
		String bookingReference = Unirest.get(url).asString().getBody();
		return bookingReference;
	}

}

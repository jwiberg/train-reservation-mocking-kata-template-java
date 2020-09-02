package kata.trainreservation.integration;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.text.IsEmptyString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kata.trainreservation.service.BookingReferenceService;

public class BookingReferenceServiceTest {

	private String serviceUrl;

	@BeforeEach
	public void beforeEach() {
		this.serviceUrl = "https://calm-temple-33806.herokuapp.com" + "/booking_reference";
	}

	@Test
	public void geBookingReference() {
		String bookingReference = new BookingReferenceService(serviceUrl).createReference();
		MatcherAssert.assertThat(bookingReference, CoreMatchers.not(IsEmptyString.emptyOrNullString()));
	}

}

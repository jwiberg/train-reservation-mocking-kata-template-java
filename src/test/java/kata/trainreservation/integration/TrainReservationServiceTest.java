package kata.trainreservation.integration;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kata.trainreservation.TrainReservationService;
import kata.trainreservation.model.Reservation;
import kata.trainreservation.service.BookingReferenceService;
import kata.trainreservation.service.TrainDataService;

public class TrainReservationServiceTest {

	private String bookingReferenceServieUrl;

	private String trainDataServiceUrl;

	@BeforeEach
	public void beforeEach() {
		this.bookingReferenceServieUrl = "https://calm-temple-33806.herokuapp.com/booking_reference";
		this.trainDataServiceUrl = "https://gentle-brushlands-56642.herokuapp.com/data_for_train/";
	}

	@Test
	public void reserveSeats() {
		Reservation reservation = null;
		try {
			reservation = new TrainReservationService(new TrainDataService(trainDataServiceUrl),
					new BookingReferenceService(bookingReferenceServieUrl)).doReservation("express_2000", 2);
		}
		catch (TrainReservationService.NoAvailableSeats noAvailableSeats) {
			Assertions.fail(noAvailableSeats);
		}

		MatcherAssert.assertThat(reservation.getSeats(), CoreMatchers.not(IsEmptyCollection.empty()));
	}

}

package kata.trainreservation;

import kata.trainreservation.model.Reservation;
import kata.trainreservation.model.Train;
import kata.trainreservation.service.BookingReferenceService;
import kata.trainreservation.service.TrainDataService;

public class App {

	private final static String trainDataServiceUrl = "https://gentle-brushlands-56642.herokuapp.com"
			+ "/data_for_train/";

	private final static String bookingReferenceServieUrl = "https://calm-temple-33806.herokuapp.com"
			+ "/booking_reference";

	public static void main(String[] args) {
		String trainId = args[0];
		Integer count = Integer.parseInt(args[1]);

		TrainReservationService trainReservationService = new TrainReservationService(
				new TrainDataService(trainDataServiceUrl), new BookingReferenceService(bookingReferenceServieUrl));

		Reservation reservation = null;
		try {
			reservation = trainReservationService.doReservation(trainId, count);
		}
		catch (TrainReservationService.NoAvailableSeats noAvailableSeats) {
			System.out.println("No available seats in that train.");
		}

		if (reservation.getSeats().size() > 0) {
			System.out.println("Seats succesfully booked. Booking reference is: "
					+ reservation.getSeats().first().getBookingReference());
		}
	}

}

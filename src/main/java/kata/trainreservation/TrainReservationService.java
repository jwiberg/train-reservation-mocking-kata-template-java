package kata.trainreservation;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import kata.trainreservation.model.Reservation;
import kata.trainreservation.model.Seat;
import kata.trainreservation.model.Train;
import kata.trainreservation.service.BookingReferenceService;
import kata.trainreservation.service.TrainDataService;

public class TrainReservationService {

	private TrainDataService trainDataService;

	private BookingReferenceService bookingReferenceService;

	public TrainReservationService(TrainDataService trainDataService, BookingReferenceService bookingReferenceService) {
		this.trainDataService = trainDataService;
		this.bookingReferenceService = bookingReferenceService;
	}

	public Reservation doReservation(String trainId, Integer count) throws NoAvailableSeats {
		Train train = trainDataService.getTrain(trainId);
		String bookingReference = bookingReferenceService.createReference();

		Set<Seat> reservedSeats = train.getSeats().stream()
				.filter(seat -> Strings.isNullOrEmpty(seat.getBookingReference())).limit(count)
				.map(seat -> new Seat(seat.getSeatId(), seat.getCoach(), seat.getSeatNumber(), bookingReference))
				.collect(Collectors.toSet());

		if (reservedSeats.size() < count) {
			throw new NoAvailableSeats();
		}

		boolean seatsAvailable = trainDataService.doReservation(trainId,
				reservedSeats.stream().map(seat -> seat.getSeatId()).toArray(String[]::new), bookingReference);

		if (!seatsAvailable) {
			throw new NoAvailableSeats();
		}

		return new Reservation(new TreeSet<>(reservedSeats));
	}

	public class NoAvailableSeats extends Exception {

	}

}

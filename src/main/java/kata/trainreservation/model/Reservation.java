package kata.trainreservation.model;

import java.util.Collections;
import java.util.SortedSet;

public class Reservation {

	SortedSet<Seat> seats;

	public Reservation(SortedSet<Seat> reservedSeats) {
		this.seats = reservedSeats;
	}

	public SortedSet<Seat> getSeats() {
		return Collections.unmodifiableSortedSet(this.seats);
	}

}

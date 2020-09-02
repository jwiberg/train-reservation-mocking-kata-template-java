package kata.trainreservation.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Seat implements Comparable<Seat> {

	private String seatId;

	private String coach;

	private Integer seatNumber;

	private String bookingReference;

	public Seat(String seatId, String coach, Integer seatNumber, String bookingReference) {
		this.seatId = seatId;
		this.coach = coach;
		this.seatNumber = seatNumber;
		this.bookingReference = bookingReference;
	}

	public String getSeatId() {
		return seatId;
	}

	public String getBookingReference() {
		return bookingReference;
	}

	public String getCoach() {
		return coach;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Seat seat = (Seat) o;
		return Objects.equal(coach, seat.seatId) && Objects.equal(coach, seat.coach)
				&& Objects.equal(seatNumber, seat.seatNumber) && Objects.equal(bookingReference, seat.bookingReference);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(seatId, coach, seatNumber, bookingReference);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("seatId", seatId).add("coach", coach).add("seatNumber", seatNumber)
				.add("bookingReference", bookingReference).toString();
	}

	@Override
	public int compareTo(Seat o) {
		return this.seatId.compareTo(o.seatId);
	}

}

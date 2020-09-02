package kata.trainreservation.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Train {

	private SortedSet<Seat> seats;

	public Train(Set<Seat> seats) {
		this.seats = new TreeSet<>(seats);
	}

	public Set<Seat> getSeats() {
		return Collections.unmodifiableSortedSet(this.seats);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Train train = (Train) o;
		return Objects.equal(seats, train.seats);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(seats);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("seats", seats).toString();
	}

}

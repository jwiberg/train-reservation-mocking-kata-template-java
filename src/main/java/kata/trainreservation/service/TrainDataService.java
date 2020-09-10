package kata.trainreservation.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import kata.trainreservation.model.Seat;
import kata.trainreservation.model.Train;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class TrainDataService {

	private String url;

	public TrainDataService(String url) {
		this.url = url;
	}

	public Train getTrain(String trainId) {
		Objects.requireNonNull(trainId);

		HttpResponse<JsonNode> response = Unirest.get(this.url + trainId).asJson();

		if (response.getStatus() != 200) {
			System.out.println("status: " + response.getStatus());
			System.out.println("body: " + response.getBody().toString());
			throw new RuntimeException("There is some technical issues in the train data service.");
		}

		JSONObject seatsJSON = (JSONObject) response.getBody().getObject().get("seats");

		Set<Seat> seats = new HashSet<>();
		seatsJSON.keySet().forEach((s) -> {
			JSONObject seatJSON = (JSONObject) seatsJSON.get(s);
			seats.add(new Seat(s, seatJSON.getString("coach"), seatJSON.getInt("seat_number"),
					seatJSON.getString("booking_reference")));
		});

		return new Train(seats);
	}

	public boolean doReservation(String trainId, String[] seats, String bookingReference) {
		List<String> mappedSeats = Arrays.stream(seats).map((s) -> "\"" + s + "\"").collect(Collectors.toList());

		HttpResponse response = Unirest.post("https://gentle-brushlands-56642.herokuapp.com/reserve")
				.field("train_id", trainId).field("seats", "[" + String.join(",", mappedSeats) + "]")
				.field("booking_reference", bookingReference).asString();

		if (response.getStatus() == 200) {
			return true;
		}
		else if (response.getStatus() == 409) {
			return false;
		}
		throw new RuntimeException("There is some technical issues in the train data service.");
	}

}
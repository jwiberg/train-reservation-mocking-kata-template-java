package kata.trainreservation.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kata.trainreservation.service.TrainDataService;
import kata.trainreservation.model.Train;

public class TrainDataServiceTest {

	private String serviceUrl;

	@BeforeEach
	public void beforeEach() {
		this.serviceUrl = "https://gentle-brushlands-56642.herokuapp.com" + "/data_for_train/";
	}

	@Test
	public void getTrain() {
		Train train = new TrainDataService(serviceUrl).getTrain("express_2000");
		Assertions.assertNotNull(train);
	}

	@Test
	public void reserveSeats() {
		try {
			TrainDataService trainDataService = new TrainDataService(this.serviceUrl);
			trainDataService.doReservation("express_2000", new String[] { "1A", "2A" }, "1234567890");
		}
		catch (Exception e) {
			Assertions.fail();
		}
	}

}

package kata.trainreservation;

import org.junit.jupiter.api.Test;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

	@Test
	public void appHasAGreeting() {
		App classUnderTest = new App();
		assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
	}

	@Test
	public void testHttpClient() {
		String data = Unirest.get("https://gentle-brushlands-56642.herokuapp.com/data_for_train/express_2000")
				.asString().getBody();
		System.out.println("-->" + data);
	}

}

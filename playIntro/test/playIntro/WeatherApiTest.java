package playIntro;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import play.libs.ws.WS;

import com.fasterxml.jackson.databind.JsonNode;


public class WeatherApiTest {
	
    @Test
    public void whenApiIsCalledAGoodResponseIsReceived() {

		running(testServer(9000, fakeApplication(inMemoryDatabase("test"))), new Runnable() {
			public void run() {
				String url = "http://localhost:9000/aTimeDemandingService";
				JsonNode asJson = WS.url(url).get().get(5000L).asJson();

				System.out.println(asJson);
				
				assertThat(asJson.toString(), containsString("Buenos Aires"));
			}
		});
    }
}

package controllers;

import play.libs.F;
import play.libs.F.Promise;
import play.libs.ws.WS;
import play.libs.ws.WSRequestHolder;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;

public class WeatherApi extends Controller {

	public static Promise<Result> aTimeDemandingService() {

		String weatherBairesUrl = "http://api.openweathermap.org/data/2.5/weather?q=Buenos%20Aires,ar";
		WSRequestHolder requestHolder = WS.url(weatherBairesUrl);

		Promise<WSResponse> promiseOfWsResponse = requestHolder.get();

		Promise<Result> jsonResponse = promiseOfWsResponse.map(new F.Function<WSResponse, Result>() {
			@Override
			public Result apply(WSResponse redeemedResponse) throws Throwable {

				System.out.println("redeemed");
				String jsonBody = redeemedResponse.getBody();
				return ok(jsonBody);
			}
		});
		
		System.out.println("returning");
		return jsonResponse;
	}
}

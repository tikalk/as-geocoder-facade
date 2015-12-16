package com.tikal.angelsense.geocodefacade;

import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goebl.david.Webb;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@RequestMapping("/api/v1")
public class GoogleGeoCoderController {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GoogleGeoCoderController.class);

	private final Webb webb = Webb.create();


	@RequestMapping("/address")
	@Cacheable("geocodesToAddreses")
//	@HystrixCommand(fallbackMethod = "getAddressLocaly")
	public String getAddress(@RequestParam final String latlng) throws InterruptedException {
		final JSONObject jsonObject = webb.get("https://maps.googleapis.com/maps/api/geocode/json")
				.param("latlng", latlng).asJsonObject().getBody();
		final String address = jsonObject.getJSONArray("results").getJSONObject(0).getString("formatted_address");
		return address;
	}
	
	private String getAddressLocaly(final String latlng){
		return "Default Address";
	}

}

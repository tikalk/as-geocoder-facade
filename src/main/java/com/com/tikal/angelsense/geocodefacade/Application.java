package com.com.tikal.angelsense.geocodefacade;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goebl.david.Webb;

@SpringBootApplication
@EnableCaching
@RestController
@RequestMapping("/api/v1")
public class Application {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Application.class);

	private final Webb webb = Webb.create();

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/address")
	@Cacheable("geocodesToAddreses")
	public String getAddress(@RequestParam final String latlng) {
		final JSONObject jsonObject = webb.get("https://maps.googleapis.com/maps/api/geocode/json")
				.param("latlng", latlng).asJsonObject().getBody();
		final String address = jsonObject.getJSONArray("results").getJSONObject(0).getString("formatted_address");
		return address;
	}

}

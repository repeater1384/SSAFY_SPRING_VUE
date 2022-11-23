package com.ssafy.webex;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.webex.dto.Country;
import com.ssafy.webex.model.mapper.WorldMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {

	@Autowired
	WorldMapper worldMapper;

	@GetMapping("/")
	public String test() throws SQLException {
//		City city = new City();
//		city.setName("도시3");
//		city.setCountryCode("KOR");
//		city.setDistrict("도시3");
//		city.setPopulation(30000);
//		int cnt = worldMapper.insertCity(city);
//		log.debug("cnt : {}", cnt);
//		log.debug("city 정보 : {}", city);
		
		List<Country>  countries = worldMapper.selectCoCl();
        for(Country country: countries) {
            log.debug(country.toString());
        }
		return "home";

	}
}

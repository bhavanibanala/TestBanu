package com.telstra.codechallenge.stars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StarsController {
	
	@Autowired
	private StarsService starsService;
	
	@GetMapping("/starsval")
	public List<FormatedData> starsRepo() throws Exception {

		List<FormatedData> listData = starsService.getStarsUsers();

		return listData;
	}
	
}

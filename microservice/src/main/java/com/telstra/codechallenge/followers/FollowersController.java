package com.telstra.codechallenge.followers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowersController {

	@Autowired
	private FollowersService followersService;

	
	@GetMapping("/followers")
	public List<ResponseData> oldestRepo() throws Exception {

		List<ResponseData> listData = followersService.getZeroFollowers();

		return listData;
	}
}

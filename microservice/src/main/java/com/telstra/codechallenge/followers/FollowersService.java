package com.telstra.codechallenge.followers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class FollowersService {

	@Value("${followers.url}")
	private String followersUrl;
	
	private RestTemplate restTemplate;

	public FollowersService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	
	public List<ResponseData> getZeroFollowers(){

		List<ResponseData> listData = new ArrayList<ResponseData>();

		try {

			ResponseEntity<Map> response = restTemplate.exchange(followersUrl, HttpMethod.GET, null, Map.class);
			Map<?, ?> map = response.getBody();
			List<?> list = (List<?>) map.get("items");
			for (int i = 0; i < list.size(); i++) {
				Map<?, ?> map1 = (Map<?, ?>) list.get(i);
				ResponseData data = new ResponseData();
				if(map1.get("html_url")!=null) {
				data.setHtmlUrl(map1.get("html_url").toString());
				}
				if(map1.get("id")!=null) {
				data.setId(map1.get("id").toString());
				}
				if(map1.get("login")!=null) {
				data.setLogin(map1.get("login").toString());
				}
				listData.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listData;
	}

}

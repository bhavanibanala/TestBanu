package com.telstra.codechallenge.stars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class StarsService {
	
	@Value("${stars.url}")
	private String starsUrl;
	
	
	
	private RestTemplate restTemplate;

	public StarsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<FormatedData> getStarsUsers(){

		List<FormatedData> listData = new ArrayList<FormatedData>();

		try {

			ResponseEntity<Map> response = restTemplate.exchange(starsUrl, HttpMethod.GET, null, Map.class);
			Map<?, ?> map = response.getBody();
			List<?> list = (List<?>) map.get("items");
			for (int i = 0; i < list.size(); i++) {
				Map<?, ?> map1 = (Map<?, ?>) list.get(i);
				FormatedData formatedData = new FormatedData();
				if(map1.get("html_url")!=null) {
					formatedData.setHtmlUrl(map1.get("html_url").toString());
					}
					if(map1.get("description")!=null) {
					formatedData.setDescription(map1.get("description").toString());
					}
					if(map1.get("language")!=null) {
					formatedData.setLanguage(map1.get("language").toString());
					}
					if(map1.get("name")!=null) {
					formatedData.setName(map1.get("name").toString());
					}
					if(map1.get("watchers_count")!=null) {
					formatedData.setWatchersCount(map1.get("watchers_count").toString());
					}
				
				listData.add(formatedData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listData;
		
	}
	
	

}

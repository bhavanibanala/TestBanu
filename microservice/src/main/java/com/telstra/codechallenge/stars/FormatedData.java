package com.telstra.codechallenge.stars;

import org.springframework.stereotype.Component;

@Component
public class FormatedData {
	
	String htmlUrl;
	String watchersCount;
	String language;
	String description;
	String name;
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}
	public String getWatchersCount() {
		return watchersCount;
	}
	public void setWatchersCount(String watchersCount) {
		this.watchersCount = watchersCount;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

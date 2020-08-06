package com.telstra.codechallenge.followers;

import com.intuit.karate.junit5.Karate;

public class FunctionalTest {
	
	 @Karate.Test
	  Karate testMicroservice() {
	    return Karate.run("followers").relativeTo(getClass());
	  }

}

package com.telstra.codechallenge.quotes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Quote {

  private String type;
  private Value value;
  
  public Quote() {
  }
  
  @Override
public String toString() {
	return "Quote [type=" + type + ", value=" + value + "]";
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Value getValue() {
	return value;
}

public void setValue(Value value) {
	this.value = value;
}



  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public class Value {

    private Long id;
    private String quote;
    
    public Value() {
    }
    
    @Override
	public String toString() {
		return "Value [id=" + id + ", quote=" + quote + "]";
	}
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
  }
}

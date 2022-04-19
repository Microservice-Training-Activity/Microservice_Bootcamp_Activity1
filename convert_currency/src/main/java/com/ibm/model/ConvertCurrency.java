package com.ibm.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity
@Component
public class ConvertCurrency {
	@Id
	@GeneratedValue
	private int id;
	
	private String currency;
	
	private double conversionFactor;
	
	@Value("${conversionurl}")
	private String url;
	
	public String getUrl() {
		return url;
	}

	public ConvertCurrency() {
		// TODO Auto-generated constructor stub
	}
	
	public ConvertCurrency(int id, String currency, double conversionFactor) {
		super();
		this.id = id;
		this.currency = currency;
		this.conversionFactor = conversionFactor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	@Override
	public String toString() {
		return "ConversionFactor [id=" + id + ", currency=" + currency + ", conversionFactor=" + conversionFactor + "]";
	}

}

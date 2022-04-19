package com.ibm.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Conversion_factor")  
public class ConversionFactor {
	@Id
	@NotNull
	@Column(name="id")  
	private int id;
	
	@Column(name="currency")  
	@Size(min = 3, message = "currency must be more than or qual 3 character")
	private String currency;
	
	@Column(name="conversion_factor")
	private double conversionFactor;
	
	public ConversionFactor() {
		// TODO Auto-generated constructor stub
	}
	
	public ConversionFactor(int id, String currency, double conversionFactor) {
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

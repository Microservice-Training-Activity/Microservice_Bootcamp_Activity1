package com.ibm.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.model.ConvertCurrency;


@RestController
@RequestMapping("/ConvertedAmount")
public class ConvertCurrencycontroller {
	
	@Autowired
	ConvertCurrency convertCurrency;
	
	@GetMapping("/currency/{currency}/amount/{amount}")
	public double getConvertedAmount(@PathVariable String currency, @PathVariable long amount) throws URISyntaxException {
		
		long uriVariables= amount;  
		System.out.println("amount=>"+amount);
		System.out.println("currency=>"+currency);
		
		ResponseEntity<ConvertCurrency> responseEntity=new RestTemplate().getForEntity(convertCurrency.getUrl()+currency, ConvertCurrency.class, uriVariables);
		ConvertCurrency response=responseEntity.getBody();  
		double conversionFactor = response.getConversionFactor();
		
		System.out.println("conversionFactor=>"+conversionFactor);
		double converted_amount = conversionFactor * amount;
		return converted_amount;
	}
}

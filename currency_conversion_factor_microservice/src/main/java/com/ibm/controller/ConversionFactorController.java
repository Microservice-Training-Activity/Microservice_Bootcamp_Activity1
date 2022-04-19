package com.ibm.controller;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.ConversionFactor;
import com.ibm.service.ConversionFactorService;

@CrossOrigin
@RestController
@RequestMapping("/conversionFactor")
public class ConversionFactorController {
	
	@Autowired
	ConversionFactorService conversionService;
	
	@GetMapping
	public List<ConversionFactor> getAllconversionFactor(){
		return conversionService.getAllConversionFactor();
	}
	
	@GetMapping("{id}")
	public ConversionFactor getConversionFactorById(@PathVariable int id)
	{
		return conversionService.getConversionFactorById(id);
	}
	
	@GetMapping("/currency/{currency}")
	public ConversionFactor getConversionFactorByCurrency(@PathVariable String currency)
	{
	    ConversionFactor result = conversionService.getConversionFactor(currency);
		return result;
	}
	
	@PostMapping
	public ResponseEntity<ConversionFactor> addConversionFactor(@Valid @RequestBody ConversionFactor conversionFactor)	
	{
		ConversionFactor result = conversionService.addConversionFactor(conversionFactor);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location)
				.body(result);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConversionFactor> updateConverionFactor(@PathVariable int id, @Valid @RequestBody ConversionFactor converionFactor )
	{
		ConversionFactor result = conversionService.updateConversionFactor(converionFactor);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(result.getId()).toUri();
				return ResponseEntity.created(location)
						.body(result);
	}

}

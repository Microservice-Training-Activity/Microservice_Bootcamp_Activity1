package com.ibm.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ibm.model.ConversionFactor;
import com.ibm.repository.ConversionFactorRepository;
import com.ibm.common.exceptions.CurrencyNotFoundException;


@Service
public class ConversionFactorService {

	@Autowired
	ConversionFactorRepository conversionFactorRepo;
	
	public List<ConversionFactor> getAllConversionFactor(){
		return conversionFactorRepo.findAll();
	}
	
	public ConversionFactor getConversionFactorById(int id) {
		return conversionFactorRepo.findById(id);
	}
	
	public ConversionFactor getConversionFactor(String currency) {
		return conversionFactorRepo.findByCurrency(currency).orElseThrow(CurrencyNotFoundException::new);
	}
	
	public ConversionFactor addConversionFactor(ConversionFactor conversionFactor) {
		return conversionFactorRepo.saveAndFlush(conversionFactor);
	}
	
	public ConversionFactor updateConversionFactor(ConversionFactor conversionFactor) {
		getConversionFactorById(conversionFactor.getId());
		return conversionFactorRepo.saveAndFlush(conversionFactor);
		
	}
}

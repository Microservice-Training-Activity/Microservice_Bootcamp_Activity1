package com.ibm.repository;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.ConversionFactor;

@Repository
public interface ConversionFactorRepository extends JpaRepository<ConversionFactor, Integer> {
	
	public List<ConversionFactor> findAll();
	public ConversionFactor findById(int id);
	public ConversionFactor findAllByCurrency(String currency);
	public Optional<ConversionFactor> findByCurrency(String currency);
}

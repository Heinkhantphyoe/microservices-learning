package com.hkp.microservices.currency_exchange_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hkp.microservices.currency_exchange_service.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

	
}

package com.hkp.microservices.currency_exchange_service.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hkp.microservices.currency_exchange_service.model.CurrencyExchange;
import com.hkp.microservices.currency_exchange_service.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
			                                      @PathVariable String to) {
		CurrencyExchange currencyExchange = this.currencyExchangeRepository.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}
//		CurrencyExchange currencyExchange = new CurrencyExchange(1001L,"USD","MYR",BigDecimal.valueOf(4.5));
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

}

package com.hkp.microservices.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hkp.microservices.currency_conversion_service.model.CurrencyConversion;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from,
			                                      @PathVariable String to);

}

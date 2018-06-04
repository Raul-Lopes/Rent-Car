package com.raul.mvc.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.raul.mvc.boot.beans.Car;
import com.raul.mvc.boot.service.CarService;

@Component
public class StringToCarConversor implements Converter<String, Car> {

	@Autowired
	private CarService service;
	
	@Override
	public Car convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}

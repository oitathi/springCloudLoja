package com.example.springCloud.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springCloud.loja.dto.CompraDto;
import com.example.springCloud.loja.model.Compra;
import com.example.springCloud.loja.service.CompraService;



@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Compra realizaCompra(@RequestBody CompraDto compra) {
		return compraService.realizaCompra(compra);
	}

}

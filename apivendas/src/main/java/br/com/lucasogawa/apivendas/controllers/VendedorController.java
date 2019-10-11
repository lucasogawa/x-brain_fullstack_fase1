package br.com.lucasogawa.apivendas.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.lucasogawa.apivendas.models.Vendedor;
import br.com.lucasogawa.apivendas.services.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	@Autowired
	private VendedorService vendedorService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Vendedor> findAll() {
		return vendedorService.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST)
	public Vendedor save(@RequestBody Vendedor vendedor) {
		return vendedorService.save(vendedor);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<Object[]> quantByVendedor(@PathVariable(value = "dataInicio") Date dataInicio, @PathVariable(value = "dataFim") Date dataFim){
		return vendedorService.quantByVendedor(dataInicio, dataFim);
	}	
}

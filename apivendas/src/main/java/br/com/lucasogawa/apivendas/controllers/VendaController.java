package br.com.lucasogawa.apivendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.lucasogawa.apivendas.models.Venda;
import br.com.lucasogawa.apivendas.repositories.VendaRepository;

@RestController
@RequestMapping("/venda")
public class VendaController {
	@Autowired
	private VendaRepository vendaRepository;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST)
	public Venda save(@RequestBody Venda venda) {
		return vendaRepository.save(venda);
	}
}

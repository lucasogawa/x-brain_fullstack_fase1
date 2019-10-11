package br.com.lucasogawa.apivendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.lucasogawa.apivendas.models.Venda;
import br.com.lucasogawa.apivendas.repositories.VendaRepository;

@Service
public class VendaService {
	@Autowired
	private VendaRepository vendaRepository;

	public Venda save(@RequestBody Venda venda) {
		return vendaRepository.save(venda);
	}
}

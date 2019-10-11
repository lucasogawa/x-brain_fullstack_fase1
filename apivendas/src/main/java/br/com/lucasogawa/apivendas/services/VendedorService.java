package br.com.lucasogawa.apivendas.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.lucasogawa.apivendas.models.Vendedor;
import br.com.lucasogawa.apivendas.repositories.VendaRepository;
import br.com.lucasogawa.apivendas.repositories.VendedorRepository;

@Service
public class VendedorService {
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private VendaRepository vendaRepository;
	
	public List<Vendedor> findAll() {
		return vendedorRepository.findAll();
	}
	
	public Vendedor save(@RequestBody Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	public List<Object[]> quantByVendedor(@PathVariable(value = "dataInicio") Date dataInicio, @PathVariable(value = "dataFim") Date dataFim){
		return vendaRepository.quantByVendedor(dataInicio, dataFim);
	}	
}

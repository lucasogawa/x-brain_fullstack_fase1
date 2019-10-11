package br.com.lucasogawa.apivendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucasogawa.apivendas.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
	
}
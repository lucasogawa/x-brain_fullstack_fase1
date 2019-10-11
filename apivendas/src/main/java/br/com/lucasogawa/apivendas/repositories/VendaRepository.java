package br.com.lucasogawa.apivendas.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.lucasogawa.apivendas.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	@Query(value = "SELECT NOME_VENDEDOR, COUNT(VENDEDOR_ID_NOME), COUNT(VENDEDOR_ID_NOME)/datediff(day, :dataInicio, :dataFim) FROM TB_VENDA, TB_VENDEDOR WHERE ID_VENDEDOR = VENDEDOR_ID_NOME AND :dataInicio <= DATA_VENDA AND :dataFim >= DATA_VENDA GROUP BY ID_VENDEDOR", nativeQuery = true)
	List<Object[]> quantByVendedor(@PathVariable(value = "dataInicio")Date dataInicio, @PathVariable(value = "dataInicio")  Date dataFim);
	
}
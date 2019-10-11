package br.com.lucasogawa.apivendas;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.lucasogawa.apivendas.models.Venda;
import br.com.lucasogawa.apivendas.models.Vendedor;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApivendasApplicationTests {
	
	private final String base = "http://localhost:8080";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	Vendedor vendedor;
	
	@Test
	public void cadastrarVendedor() {
		 vendedor = restTemplate.postForObject(base + "/vendedor", new Vendedor("Lucas"), Vendedor.class);
		
		Assert.assertEquals("1" + "Lucas", vendedor.getId() + vendedor.getNome());
	}
	
	@Test
	public void cadastrarVenda() {
		Venda res = restTemplate.postForObject(base + "/venda", new Venda(new java.sql.Date(2019, 10, 10), 1.99, vendedor), Venda.class);
		
		Assert.assertEquals(1, res.getId());
	}

}

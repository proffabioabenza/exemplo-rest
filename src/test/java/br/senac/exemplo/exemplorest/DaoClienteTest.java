package br.senac.exemplo.exemplorest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class DaoClienteTest {
	
	private static Cliente cliente;
	
	@Test
	@Order(1)
	public void testInsertion() {
		cliente = new Cliente();
		
		cliente.setNome("Ana");
		cliente.setCpf("123456789");
		
		assertDoesNotThrow(() -> {
			cliente = new DaoCliente().inserir(cliente);
			assertNotNull(cliente);
		});
	}
	
	@Test
	@Order(2)
	public void testUpdate() {
		
		assertDoesNotThrow(() -> {
			cliente.setNome("Pedro");

			cliente = new DaoCliente().atualizar(cliente);
			assertNotNull(cliente);
			assertEquals(cliente.getNome(), "Pedro");
		});
	}
}

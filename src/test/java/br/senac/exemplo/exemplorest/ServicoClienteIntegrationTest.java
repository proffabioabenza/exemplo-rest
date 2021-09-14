package br.senac.exemplo.exemplorest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ServicoClienteIntegrationTest {

    private HttpServer server;
    private WebTarget target;

    @BeforeEach
    public void setUp() throws Exception {
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @AfterEach
    public void tearDown() throws Exception {
        server.shutdown();
    }
    
    @Test
    public void testeInserir() {
    	Cliente cli = new Cliente();
    	cli.setNome("João");
    	cli.setCpf("123");
        Entity<Cliente> clienteEntity = Entity.entity(cli, MediaType.APPLICATION_JSON);

        Cliente cliente = target.path("cliente").request().post(clienteEntity, Cliente.class);
        assertNotNull(cliente);
        assertEquals(cli.getNome(), cliente.getNome());
        assertEquals(cli.getCpf(), cliente.getCpf());      
    }
    
}

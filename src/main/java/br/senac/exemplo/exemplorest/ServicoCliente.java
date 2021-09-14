package br.senac.exemplo.exemplorest;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cliente")
public class ServicoCliente {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente inserirCliente(Cliente cliente) {
		try {
			return new DaoCliente().inserir(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarClientes() {
		try {
			return new DaoCliente().listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente atualizarCliente(Cliente cliente) {
		try {
			return new DaoCliente().atualizar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void removerCliente(@PathParam("id") Integer id) {
		try {
			new DaoCliente().excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Cliente obterCliente(@PathParam("id") Integer id) {
		try {
			return new DaoCliente().obter(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

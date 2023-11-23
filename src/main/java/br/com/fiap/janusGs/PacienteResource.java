package br.com.fiap.janusGs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.janusGs.model.Paciente;
import br.com.fiap.janusGs.service.PacienteService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("paciente")
public class PacienteResource {
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response listAll() {
		 return Response.ok().build(); 
	 }
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) throws SQLException {
		if(id != 0) {
		var paciente = PacienteService.findById(id);
		
		if(paciente == null) {
			System.out.println("Paciente não encontrado!");
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(paciente).build();
		} else {
			var paciente = PacienteService.findAll();
			
			if(((ArrayList<Paciente>) paciente).isEmpty()) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			
			return Response.ok(paciente).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Paciente paciente) {
		if (!PacienteService.create(paciente)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(paciente).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Paciente paciente) {
		paciente.setIdPaciente(id);
		if(!PacienteService.update(paciente)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(paciente).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response destroy(@PathParam("id") int id) throws SQLException {
		var paciente = PacienteService.findById(id);
		
		if(paciente == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		PacienteService.delete(id);
		return Response.noContent().build();
	}
}

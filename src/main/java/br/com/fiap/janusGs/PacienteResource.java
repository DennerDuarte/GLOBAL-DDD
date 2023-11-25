package br.com.fiap.janusGs;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.janusGs.model.Paciente;
import br.com.fiap.janusGs.service.PacienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("paciente")
public class PacienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos() throws SQLException {
        List<Paciente> pacientes = PacienteService.findAll();
        return Response.ok(pacientes).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterPorId(@PathParam("id") int id) throws SQLException {
        if (id != 0) {
            Paciente paciente = PacienteService.findById(id);

            if (paciente != null) {
                return Response.ok(paciente).build();
            } else {
                System.out.println("Paciente não encontrado!");
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } else {
            List<Paciente> pacientes = PacienteService.findAll();

            if (pacientes.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(pacientes).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response criar(Paciente paciente) {
        if (!PacienteService.create(paciente)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(paciente).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam("id") int id, Paciente paciente) {
        paciente.setIdPaciente(id);
        if (!PacienteService.update(paciente)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(paciente).build();
    }

    @DELETE
    @Path("{id}")
    public Response excluir(@PathParam("id") int id) {
        try {
            Paciente paciente = PacienteService.findById(id);

            if (paciente != null) {
                PacienteService.delete(paciente);
                return Response.noContent().build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}

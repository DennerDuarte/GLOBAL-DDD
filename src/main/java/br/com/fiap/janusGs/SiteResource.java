package br.com.fiap.janusGs;

import br.com.fiap.janusGs.model.Site;
import br.com.fiap.janusGs.service.SiteService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("site")
public class SiteResource {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Site site) {
		if (!SiteService.create(site)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(site).build();
	}
}

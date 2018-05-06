package com.example.journeyservice.rest;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("/journeys")
@Produces(MediaType.APPLICATION_JSON)
//@RequestScoped
public class JourneyServiceEndpoint {

	@Inject
	private JourneyRepository journeyRepository;

	@GET
	@Path("/all")
	public Response allJourneys() {
		//Stream.of("big ride", "awesome", "quickie").forEach(Journey::new);
		return Response.ok(journeyRepository.findAll()).build();
	}
}
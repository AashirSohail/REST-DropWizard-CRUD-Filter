package edu.seecs.dropwizard;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.server.Authentication.User;

import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring.db.main.GWClass;
import spring.db.model.Person;

@Path("/person")
@Api(value = "/Person", description = "Person case study")
public class DeviceResources {

	@SuppressWarnings("unused")
	private final Validator validator_;

	public DeviceResources(Validator validator) {
		validator_ = validator;
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get person", notes = "Get person", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Internal Server error !"),
			@ApiResponse(code = 404, message = "Not found !"),
			@ApiResponse(code = 401, message = "Unauthorized access !") })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") long deviceId) {
		GWClass gwClass = new  GWClass("spring.xml");
		List<Person> persons = gwClass.listPerson();
		for(Person  personRet  : persons){
			System.out.println(personRet.getFirstName());
		}
		return Response.ok(persons).build();

	}

	@POST
	@ApiOperation(value = "Add person.", notes = "Add person", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Internal Server error !"),
			@ApiResponse(code = 404, message = "Not found !"),
			@ApiResponse(code = 401, message = "Unauthorized access !") })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@Valid DeviceDataDTO deviceDataDTO) {
		return Response.ok().build();
	}
	
	@RolesAllowed({ "ADMIN" })
	@PUT
	@Path("/{id}")
	@ApiOperation(value = "Update person.", notes = "Update person", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Updated person"),
			@ApiResponse(code = 500, message = "Internal Server error !"),
			@ApiResponse(code = 404, message = "Not found !"),
			@ApiResponse(code = 401, message = "Unauthorized access !") })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("id") long deviceId,  @Auth User user) {
		return Response.ok().build();
	}
	
	@RolesAllowed({ "ADMIN" })
	@DELETE
	@Path("/{id}")
	@ApiOperation(value = "Delete person", notes = "Delete person", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Person deleted"),
			@ApiResponse(code = 500, message = "Internal Server error !"),
			@ApiResponse(code = 404, message = "Not found !"),
			@ApiResponse(code = 401, message = "Unauthorized access !") })
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response del(@PathParam("id") long deviceId,  @Auth User user) {
		return Response.ok().build();
	}

}

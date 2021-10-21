package at.htl.boundary;

import at.htl.control.PersonRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/persons")
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    @GET
    public Response findAll(){
        return Response.ok(personRepository.findAllPersons()).build();
    }
}

package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.entities.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.Time;
import java.sql.Timestamp;

@RequestScoped
@Path("/persons")
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    /*@GET
    public Response findAll(){
        return Response.ok(personRepository.findAllPersons()).build();
    }*/

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person, @Context UriInfo info){
        person.setTime( new Timestamp(System.currentTimeMillis()));
        person = personRepository.save(person);

        UriBuilder uriBuilder = info
                .getAbsolutePathBuilder()
                .path(Long.toString(person.getId()));

        return Response.status(200).entity(person).build();
    }
}

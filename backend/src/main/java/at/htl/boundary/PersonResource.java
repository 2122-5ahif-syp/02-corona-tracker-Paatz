package at.htl.boundary;

import at.htl.control.PersonRepository;
import at.htl.entities.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
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
    public Response createPerson(
        @FormParam("firstName") String firstName,
        @FormParam("lastName") String lastName,
        @FormParam("email") String email,
        @FormParam("time") Timestamp time
    ){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setTime( new Timestamp(System.currentTimeMillis()));
        return Response.status(200).entity(person).build();
    }
}

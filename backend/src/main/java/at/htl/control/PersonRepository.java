package at.htl.control;

import at.htl.entities.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Transactional
    public Person save(Person personToSave) {
        return getEntityManager().merge(personToSave);
    }


}

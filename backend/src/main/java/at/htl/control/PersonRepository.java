package at.htl.control;

import at.htl.entities.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Transactional
    public Person save(Person personToSave) {
        return getEntityManager().merge(personToSave);
    }


    public List<Person> findAllPersons() {
        return Collections.unmodifiableList(listAll());
    }
}

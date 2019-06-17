package zhang.sssp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import zhang.sssp.dao.PersonDao;
import zhang.sssp.entities.Person;
@Repository
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager EntityManager=null;
	
	@Override
	public Person getPerosn(Integer id) {
		Person person = EntityManager.find(Person.class, id);
		return person;
	}

	@Override
	public void savePerson(Person person) {
		System.out.println(EntityManager);
		EntityManager.persist(person);
	}

	@Override
	public List<Person> getAllperson() {
		return EntityManager.createQuery("from Person").getResultList();
	}

}

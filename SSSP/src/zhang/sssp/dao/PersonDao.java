package zhang.sssp.dao;

import java.util.List;

import zhang.sssp.entities.Person;

public interface PersonDao {
	
	public Person getPerosn(Integer  id);
	
	public void savePerson(Person person);
	
	public List<Person> getAllperson();

}

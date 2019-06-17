package zhang.sssp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zhang.sssp.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}

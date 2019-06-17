package zhang.sssp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zhang.sssp.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}

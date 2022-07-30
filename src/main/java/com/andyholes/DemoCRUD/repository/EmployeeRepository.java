package com.andyholes.DemoCRUD.repository;

import com.andyholes.DemoCRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //metodos CRUD de la base de datos
    //heredo los metodos findAll, findAllById, etc...

}

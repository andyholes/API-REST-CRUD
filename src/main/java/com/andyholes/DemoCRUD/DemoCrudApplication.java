package com.andyholes.DemoCRUD;

import com.andyholes.DemoCRUD.model.Employee;
import com.andyholes.DemoCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCrudApplication implements CommandLineRunner {
//implemento la interfaz para poder correr el metodo run y agregar elementos de prueba

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("andy");
		employee.setLastName("holes");
		employee.setEmailId("andyholesdev@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("JUAN");
		employee1.setLastName("PEREZ");
		employee1.setEmailId("juanperez@gmail.com");
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setFirstName("pepe");
		employee2.setLastName("gomez");
		employee2.setEmailId("gomez2095@gmail.com");
		employeeRepository.save(employee2);
	}
}

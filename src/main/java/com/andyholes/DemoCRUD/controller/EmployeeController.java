package com.andyholes.DemoCRUD.controller;

import com.andyholes.DemoCRUD.exception.ResourceNotFoundException;
import com.andyholes.DemoCRUD.model.Employee;
import com.andyholes.DemoCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //convierte la clase en controlador spring mvc rest y maneja las peticiones http
@RequestMapping("/api/v1.0/employees") //defino la url de mi api rest en un formato correcto
public class EmployeeController {

    @Autowired //inyecto dependencias con constructor
    private EmployeeRepository employeeRepository;

    @GetMapping //responde a un get request para todos los empleados
    public List<Employee> getAlleEmployes(){
        return employeeRepository.findAll(); //devuelve una lista de empleados al cliente
    }

    //REST API creacion de empleado
    @PostMapping //responde a un post request
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee); //uso el metodo save y le envio el empleado
    } //la anotacion RequestBody recibe y convierte un Json en objeto de Java

    //REST API obtener empleado por id
    @GetMapping("{id}") //id sera argumento del metodo, de modo que paso el id como variable de ruta en el url
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
//@PathVariable hace que el parametro id este linkeado al que recibe @GetMapping en la url
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el id: " + id));
                return ResponseEntity.ok(employee);
    } //Busco por id, y en caso de no existir creo una instancia de la excepcion (pasada como expresion lambda)

    //REST API editar empleado
    @PutMapping("{id}") //POST se usa para crear un recurso y PUT para actualizarlo
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
//employeeDetails sera el objeto con la informacion actualizada que envia el cliente cuando invoca esta apiRest
    Employee updateEmployee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el id: " + id));
//cargo la informacion actualizada en updateEmployee
    updateEmployee.setFirstName(employeeDetails.getFirstName());
    updateEmployee.setLastName(employeeDetails.getLastName());
    updateEmployee.setEmailId(employeeDetails.getEmailId());
//y guardo esta info en la base de datos
    employeeRepository.save(updateEmployee);
    return ResponseEntity.ok(updateEmployee);
    }

    //REST API borrar empleado
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
//
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe empleado con el id: " + id));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

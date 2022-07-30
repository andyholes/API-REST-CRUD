package com.andyholes.DemoCRUD.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//Podria cambiar @G.. y @S.. con @Data pero incluye cosas que no necesito
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "employees")
public class Employee {

    @Id //Id sera la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de generacion de la clave primaria
    private long id;

    @Column(name="first_name") //jpa toma por default el nombre de la variable pero las defino igual
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;
}

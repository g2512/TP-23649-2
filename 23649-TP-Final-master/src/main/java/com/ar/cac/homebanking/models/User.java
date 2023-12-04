package com.ar.cac.homebanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mail")
    private String email;

    @Column(name = "contrasena")
    private String password;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String surname;

    @Column (name = "dni")
    private String dni;

    @Column (name = "Creado_el")
    private String createdAt;

    @Column (name = "Modificado_el")
    private String updatedAt;

}

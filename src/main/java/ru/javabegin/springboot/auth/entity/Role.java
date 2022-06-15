package ru.javabegin.springboot.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ROLE_DATA")
public class Role {

    @Id
    @Column(name = "id")@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

        @Column(name = "name", nullable = false, length = -1)
    private String name;


}

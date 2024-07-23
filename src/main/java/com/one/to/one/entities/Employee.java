package com.one.to.one.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "manager") // it will not create new column, because we're utilizing before one (mapped by)
    @JsonIgnore
    private Department managedDepartment;
}

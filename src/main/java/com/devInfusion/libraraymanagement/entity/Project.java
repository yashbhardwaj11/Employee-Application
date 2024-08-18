package com.devInfusion.libraraymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String clientName;
    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();

    public Project(String name, String clientName) {
        this.name = name;
        this.clientName = clientName;
    }
}


package com.fennec.freelanceproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @OneToMany(mappedBy = "category")
    private Collection<Technology> technologies = new ArrayList<>();
}

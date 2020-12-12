package com.fennec.freelanceproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Technology {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

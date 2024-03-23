package org.example.springwebmvc.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name="products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String name;
    private Double price;
    private Integer qty;
    private LocalDateTime importedDate;
    private Boolean status;

//    @ManyToOne
//    private Category category;
}

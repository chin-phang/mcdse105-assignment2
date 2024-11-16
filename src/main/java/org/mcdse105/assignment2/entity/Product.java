package org.mcdse105.assignment2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description = "";

    @Column(length = 200, nullable = false)
    private String category = "";

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price = BigDecimal.ZERO;

    private Integer quantity = 0;

}

package hu.progmatic.ordertracking_1021.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "place_of_birth")
    private String birthPlace;
    @Column(name = "time_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthTime;
    private String email;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Demand> orders;
}

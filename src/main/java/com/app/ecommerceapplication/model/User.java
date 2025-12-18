package com.app.ecommerceapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

//@AllArgsConstructor
@Data //lombok data is used in place of creating the getter/setter.lombok generate code and send to .class
@NoArgsConstructor // JPA require default constructor
@Entity(name = "user_table") //User class is treated as db table.
public class User {
    @Id //make PK with unique value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role = UserRole.CUSTOMER;

    //linking address table to user table
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name= "address_id", referencedColumnName = "id")
    private Address address;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

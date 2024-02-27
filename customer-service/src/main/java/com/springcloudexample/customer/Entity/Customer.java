package com.springcloudexample.customer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "customer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Document cannot be empty")
    @Size(max = 8, min = 8, message = "Size of document must be 8")
    @Column(name = "number_id", unique = true, length = 8, nullable = false)
    private String numberId;

    @NotNull(message = "First name cannot be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull(message = "Last Name cannot be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull(message = "email cannot be empty")
    @Email(message = "This email is not valid")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    @Column
    private String state;


}

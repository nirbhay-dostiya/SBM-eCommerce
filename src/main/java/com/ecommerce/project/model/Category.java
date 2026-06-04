package com.ecommerce.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "categories")
@Data    // Generates getters, setters, toString, etc.
@NoArgsConstructor   // no-argument constructor (a default constructor) for your class.
@AllArgsConstructor  // one argument for every field in your class, in the exact order they are declared.
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank // This is for validation its means users not give null value

//  @Size(min = 5)  // this is to constrain the size so atleast .... words must write
    @Size(min = 5, message = "Category must contain 5 characters")  // for custom message
    private String categoryName;

}

package com.threepounds.cityservice.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "streets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Street {
    @Id
    @GeneratedValue
    @Column
    private UUID id;
    @Column
    private String name;

}

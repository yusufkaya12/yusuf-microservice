package com.threepounds.cityservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Column
    @GeneratedValue
    @Id
    private UUID id;
    @Column
    private String name;
    @OneToMany
    private List<County> counties;

}

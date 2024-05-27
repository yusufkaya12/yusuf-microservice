package com.threepounds.cityservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "counties")
public class County {
    @GeneratedValue
    @Id
    @Column
    private UUID id;
    @Column
    private String name;
    @OneToMany
    private List<Street> streets;

}

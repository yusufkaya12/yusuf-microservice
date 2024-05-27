package com.threepounds.baseservice.shared.sharedfood;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class SharedIngredient implements Serializable {
    private UUID id;
    private String name;
}

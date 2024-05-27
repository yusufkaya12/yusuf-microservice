package com.threepounds.baseservice.shared.sharedfood;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Data
@EqualsAndHashCode(callSuper = false)
public class SharedFood implements Serializable {
    private UUID id;
    private String name;
    private List<SharedIngredient> ingredients;
    private SharedCategory category;

}

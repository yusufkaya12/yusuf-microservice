package com.threepounds.baseservice.shared.shareduser;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class SharedUser implements Serializable {
    private UUID id;
    private String username;
    private String name;

}

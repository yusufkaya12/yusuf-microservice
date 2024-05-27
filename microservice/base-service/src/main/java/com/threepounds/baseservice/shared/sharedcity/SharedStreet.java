package com.threepounds.baseservice.shared.sharedcity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;
@Data
@EqualsAndHashCode(callSuper = false)
public class SharedStreet implements Serializable {
    private String name;
    private UUID id;

}

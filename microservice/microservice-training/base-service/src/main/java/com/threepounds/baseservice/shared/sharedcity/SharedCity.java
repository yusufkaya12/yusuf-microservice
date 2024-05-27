package com.threepounds.baseservice.shared.sharedcity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class SharedCity implements Serializable {
  private UUID id;
  private String name;

}

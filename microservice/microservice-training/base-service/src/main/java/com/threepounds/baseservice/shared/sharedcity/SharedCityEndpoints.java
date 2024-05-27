package com.threepounds.baseservice.shared.sharedcity;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedCityEndpoints {
  static final String CITIES = "/cities";
  static final String CITIES_ID = "/cities/{id}";

   static final String CITY="/cities";
}

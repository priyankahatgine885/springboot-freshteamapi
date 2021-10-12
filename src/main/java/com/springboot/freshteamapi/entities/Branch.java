package com.springboot.freshteamapi.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Branch {
    Long id;
    String created_at;
    String updated_at;
    Boolean deleted;
    String name;
    String state;
    String city;
    String countryCode;
    String zip;
    String time_zone;
    String currency;
    String language;
    Boolean main_office;
    String date_format;
    String street;
}

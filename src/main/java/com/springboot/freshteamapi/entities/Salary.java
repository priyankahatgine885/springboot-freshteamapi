package com.springboot.freshteamapi.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Salary {
    Integer min;
    Integer max;
    String currency;


}

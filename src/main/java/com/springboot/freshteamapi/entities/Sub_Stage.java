package com.springboot.freshteamapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Sub_Stage {
    Long id;
    Boolean deleted;
    String name;
    Integer position;
    Boolean Default;
    String stage;


}

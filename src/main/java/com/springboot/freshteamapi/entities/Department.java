package com.springboot.freshteamapi.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Department {
    Long id;
    String created_at;
    String updated_at;
    Boolean deleted;
    String name;

}

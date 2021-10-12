package com.springboot.freshteamapi.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class InterviewProcess {
    Long id;
    List<Sub_Stage> sub_stages = new ArrayList<>();
}

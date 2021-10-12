package com.springboot.freshteamapi.entities;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class PanelMember {
    Long id;
    String first_name;
    String last_name;
    String official_email;
    // List<InterviewerTimeOff> timeOffList;
}

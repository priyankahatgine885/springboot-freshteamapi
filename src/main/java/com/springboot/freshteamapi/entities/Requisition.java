package com.springboot.freshteamapi.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Requisition {
    Long id;
    Boolean deleted;
    String title;
    List<Recruiter> recruiters = new ArrayList<>();
    List<HiringManagers> hiring_managers = new ArrayList<>();
    List<PanelMember> panel_members = new ArrayList<>();
}

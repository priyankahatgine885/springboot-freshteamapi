package com.springboot.freshteamapi.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Response {
    Long id;
    String created_at;
    String updated_at;
    Boolean deleted;
    String title;
    String description;
    String status;
    Salary salary;
    String applicant_access_type;
    Boolean remote;
    Boolean show_pursue_as_career;
    String closing_date;
    String applicant_apply_link;
    String experience;
    String type;
    Branch branch;
    Department department;
    InterviewProcess interviewProcess;
    Object custom_field_values;
    List<String> skills = new ArrayList<>();
    List<Branch> remote_branches = new ArrayList<>();
    List<Requisition> requisitions = new ArrayList<>();


}

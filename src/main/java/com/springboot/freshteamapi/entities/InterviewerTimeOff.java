package com.springboot.freshteamapi.entities;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class InterviewerTimeOff {
    Long id;
    String created_at;
    String updated_at;
    Long user_id;
    String start_date;
    String end_date;
    String status;
    Float leave_units;
    Integer optional_leave_units;
    Long leave_type_id;
    String status_comments;
    Long approved_by_id;
    Long applied_by_id;
    Long cancelled_by_id;
    Long rejected_by_id;
    String comments;
    String rejected_at;
    String cancelled_at;
    Boolean cancelled_due_to_exit;
}

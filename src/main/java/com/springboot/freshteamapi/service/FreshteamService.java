package com.springboot.freshteamapi.service;

import com.springboot.freshteamapi.entities.InterviewerTimeOff;
import com.springboot.freshteamapi.entities.PanelMember;
import com.springboot.freshteamapi.entities.Response;
import org.json.JSONException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreshteamService {
    private final String accessToken;
    private final String accountId;

    public FreshteamService(String accessToken, String accountId) {
        this.accessToken = accessToken;
        this.accountId = accountId;
    }

    public String getEmployeesList() {
        System.out.println(accessToken);
        String url = "https://" + accountId + "." + FreshTeamConstant.FRESHTEAM_DOMAIN + "/" + FreshTeamConstant.GET_EMPLOYEE;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate = new RestTemplateBuilder(rt -> rt.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", accessToken);
            return execution.execute(request, body);
        })).build();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public String getJobPostingsList() {
        String url = "https://" + accountId + "." + FreshTeamConstant.FRESHTEAM_DOMAIN + "/" + FreshTeamConstant.GET_JOB_POSTINGS;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate = new RestTemplateBuilder(rt -> rt.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", accessToken);
            return execution.execute(request, body);
        })).build();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    public Response getJobPostingListById(Object id) {
        String url = "https://" + accountId + "." + FreshTeamConstant.FRESHTEAM_DOMAIN + "/" + FreshTeamConstant.GET_JOB_POSTINGS + "/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate = new RestTemplateBuilder(rt -> rt.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", accessToken);
            return execution.execute(request, body);
        })).build();
        Response result = restTemplate.getForObject(url, Response.class);
        return result;
    }

    public InterviewerTimeOff[] getTimeOffOfPanelMembersById(Long userId) throws JSONException {
        String url = "https://" + accountId + "." + FreshTeamConstant.FRESHTEAM_DOMAIN + "/" + FreshTeamConstant.GET_TimeOff + "=" + userId;
        RestTemplate restTemplate = new RestTemplateBuilder(rt -> rt.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", accessToken);
            return execution.execute(request, body);
        })).build();
        InterviewerTimeOff[] result = restTemplate.getForObject(url, InterviewerTimeOff[].class);
        for (InterviewerTimeOff interviewer : result) {
            System.out.println(interviewer);
        }
        return result;

//        ResponseEntity<List<InterviewerTimeOff>> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<InterviewerTimeOff>>() {
//                });
//        List<InterviewerTimeOff> iInterviewerTimeOffs = response.getBody();
//        return null;
    }

    public Map<Long, InterviewerTimeOff[]> getTimeOffOfAllPanelMembers(Map<String, List<PanelMember>> map) throws JSONException {
        Map<Long, InterviewerTimeOff[]> interviewerTimeOffMap = new HashMap<>();
        for (Map.Entry<String, List<PanelMember>> entry : map.entrySet()) {
            List<PanelMember> panelMembersList = entry.getValue();
            for (PanelMember panelMember : panelMembersList) {
                Long panelMemberId = panelMember.getId();
                if (interviewerTimeOffMap.get(panelMemberId) == null) {
                    InterviewerTimeOff[] timeOff = getTimeOffOfPanelMembersById(panelMemberId);
                    interviewerTimeOffMap.put(panelMemberId, timeOff);
                }
            }

        }
        return interviewerTimeOffMap;
    }
}

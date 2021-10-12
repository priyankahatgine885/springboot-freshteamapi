package com.springboot.freshteamapi;

import com.springboot.freshteamapi.entities.InterviewerTimeOff;
import com.springboot.freshteamapi.entities.PanelMember;
import com.springboot.freshteamapi.entities.Requisition;
import com.springboot.freshteamapi.entities.Response;
import com.springboot.freshteamapi.service.FreshteamService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootConfiguration
@org.springframework.boot.autoconfigure.SpringBootApplication
public class FreshTeamApplication implements CommandLineRunner {
    @Value("${freshteam.token}")
    private String accessToken;
    @Value("${freshteam.accountId}")
    private String accountId;
    Map<String, List<PanelMember>> map = new HashMap<>();


    public static void main(String[] args) {
        System.out.println("Enter main1 : ");
        SpringApplication.run(FreshTeamApplication.class, args);
        System.out.println("End Main1 ");
    }

    @Override
    public void run(String... args) throws Exception {
        FreshteamService freshteamService = new FreshteamService(accessToken, accountId);
        String jsonData = freshteamService.getJobPostingsList();
        JSONArray jsonArray = new JSONArray(jsonData);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            Object id = json.get("id");
            Response response = freshteamService.getJobPostingListById(id);
            List<Requisition> requisitionsList = response.getRequisitions();
            for (Requisition requisition : requisitionsList) {
                List<PanelMember> panelMembersList = requisition.getPanel_members();
                map.put(response.getTitle(), panelMembersList);
            }
        }
//        Iterator<Map.Entry<String, List<PanelMember>>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, List<PanelMember>> entry = iterator.next();
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }

        Map<Long, InterviewerTimeOff[]> interviewerTimeOff = freshteamService.getTimeOffOfAllPanelMembers(map);
        Iterator<Map.Entry<Long, InterviewerTimeOff[]>> entryIterator = interviewerTimeOff.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Long, InterviewerTimeOff[]> entryMap = entryIterator.next();
            if (entryMap.getValue() != null) {
                InterviewerTimeOff[] interviewerTimeOffs = entryMap.getValue();
                for (InterviewerTimeOff timeOff : interviewerTimeOffs) {
                    System.out.println(entryMap.getKey() + " = " + timeOff);
                }
            }
            System.out.println(entryMap.getKey() + " = " + " No Leave ");
        }
    }
}




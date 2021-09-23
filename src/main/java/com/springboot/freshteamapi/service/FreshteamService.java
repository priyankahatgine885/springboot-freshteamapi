package com.springboot.freshteamapi.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class FreshteamService {
    private String accessToken;
    private  String accountId;
    public FreshteamService(String accessToken, String accountId) {
        this.accessToken = accessToken;
        this.accountId = accountId;
    }

    public String getEmployeesList() {
        System.out.println(accessToken);
        String url = "https://" + accountId + "." + FreshTeamConstansts.FRESHTEAM_DOMAIN + "/" + FreshTeamConstansts.GET_EMPLOYEE;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate = new RestTemplateBuilder(rt -> rt.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization",  accessToken);
            return execution.execute(request, body);
        })).build();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

}

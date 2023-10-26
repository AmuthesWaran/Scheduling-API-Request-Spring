package com.ammu.Spring.Schedular;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@EnableScheduling
public class ScheduledTasks {

    private boolean checkCondition() {
        return true;
    }

    private void deleteApiRequest() {

        RestTemplate restTemplate = new RestTemplate();
        String deleteUrl = "http://localhost:3000/users/1";
        restTemplate.delete(deleteUrl);

    }

    @Scheduled(cron = "0 * * * * *")
    public void scheduledDeleteApiRequest() {
        if (checkCondition()) {
            deleteApiRequest();
        }
    }


}

package com.ss.trip;

import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final BlockingQueue<Trip> locationDataQueue = new LinkedBlockingQueue<>();

    @MessageMapping("/sendData")
    public void sendData(String data) {
        Trip trip = new Trip(1, 1, "Current Location "+Calendar.getInstance().getTimeInMillis(), "Location B", "In Progress");
        locationDataQueue.add(trip);
    }

    @Scheduled(fixedRate = 1000) 
    public void processQueueAndSend() {
        Object data = processQueueData();
        messagingTemplate.convertAndSend("/topic/data", data);
    }

    private Object processQueueData() {
        Trip queueData = locationDataQueue.poll(); 
        return (queueData != null) ? queueData : "Trip Not Started";
    }
}

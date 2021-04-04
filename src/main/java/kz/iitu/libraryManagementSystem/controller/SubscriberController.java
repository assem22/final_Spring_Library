package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Subscriber;
import kz.iitu.libraryManagementSystem.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    public List<Subscriber> getSubscribers() {
        return subscriberService.findAllPublishers();
    }

    public void createSubscribers(Subscriber subscriber) {
        subscriberService.createSubscriber(subscriber);
    }

    public void update(Subscriber subscriber) {
        subscriberService.updateSubscriber(subscriber);
    }
}

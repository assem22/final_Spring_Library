//package kz.iitu.libraryManagementSystem.controller;
//
//import kz.iitu.libraryManagementSystem.entity.Subscriber;
//import kz.iitu.libraryManagementSystem.service.SubscriberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/subscribers")
//public class SubscriberController {
//
//    @Autowired
//    private SubscriberService subscriberService;
//
//    @GetMapping("")
//    public List<Subscriber> getSubscribers() {
//        return subscriberService.findAllPublishers();
//    }
//
//    @PostMapping("")
//    public void createSubscribers(@RequestBody Subscriber subscriber) {
//        subscriberService.createSubscriber(subscriber);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable Long id,
//                       @RequestBody Subscriber subscriber) {
//        subscriber.setSubscriber_id(id);
//        subscriberService.updateSubscriber(subscriber);
//    }
//}
//
////@Controller
////public class SubscriberController {
////
////    @Autowired
////    private SubscriberService subscriberService;
////
////    public List<Subscriber> getSubscribers() {
////        return subscriberService.findAllPublishers();
////    }
////
////    public void createSubscribers(Subscriber subscriber) {
////        subscriberService.createSubscriber(subscriber);
////    }
////
////    public void update(Subscriber subscriber) {
////        subscriberService.updateSubscriber(subscriber);
////    }
////}

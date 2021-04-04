package kz.iitu.libraryManagementSystem.service;

import kz.iitu.libraryManagementSystem.entity.Subscriber;

import java.util.List;
import java.util.Optional;

public interface SubscriberService {
    List<Subscriber> findAllPublishers();

    Optional<Subscriber> findPublisherById(Long id);

    void createSubscriber(Subscriber subscriber);

    void updateSubscriber(Subscriber subscriber);

    void deleteSubscriber(Long id);
}

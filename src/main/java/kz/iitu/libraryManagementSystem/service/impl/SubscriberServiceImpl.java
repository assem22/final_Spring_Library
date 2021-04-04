package kz.iitu.libraryManagementSystem.service.impl;

import kz.iitu.libraryManagementSystem.entity.Subscriber;
import kz.iitu.libraryManagementSystem.repository.SubscriberRepository;
import kz.iitu.libraryManagementSystem.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public List<Subscriber> findAllPublishers() {
        return subscriberRepository.findAll();
    }

    @Override
    public Optional<Subscriber> findPublisherById(Long id) {
        return subscriberRepository.findById(id);
    }

    @Override
    public void createSubscriber(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
    }

    @Override
    public void updateSubscriber(Subscriber subscriber) {
//        Subscriber updatedSubscriber = subscriberRepository.findById(subscriber.getSubscriber_id()).get();
        subscriberRepository.save(subscriber);
    }

    @Override
    public void deleteSubscriber(Long id) {
        subscriberRepository.deleteById(id);
    }
}

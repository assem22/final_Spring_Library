package kz.iitu.libraryManagementSystem.repository;

import kz.iitu.libraryManagementSystem.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}

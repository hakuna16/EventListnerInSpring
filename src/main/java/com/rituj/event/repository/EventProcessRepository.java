package com.rituj.event.repository;

import com.rituj.event.models.EventMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventProcessRepository extends JpaRepository<EventMessage, Integer> {
}

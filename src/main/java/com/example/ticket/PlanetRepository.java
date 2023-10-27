package com.example.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, String> {
    Optional<Object> findById(String id);
    // Тут можна додати власні методи, якщо потрібно
}

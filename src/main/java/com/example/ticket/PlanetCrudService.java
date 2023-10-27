package com.example.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetCrudService {

    @Autowired
    private PlanetRepository planetRepository;

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    public Planet getPlanetById(String id) {
        return planetRepository.findById(id).orElse(null);
    }

    public Planet createPlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    public Planet updatePlanet(String id, Planet planetDetails) {
        Planet planet = planetRepository.findById(id).orElse(null);
        if (planet != null) {
            planet.setName(planetDetails.getName());
            return planetRepository.save(planet);
        }
        return null;
    }

    public void deletePlanet(String id) {
        planetRepository.deleteById(id);
    }
}
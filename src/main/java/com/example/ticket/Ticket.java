package com.example.ticket;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "start_planet_id")
    private Planet startPlanet;

    @ManyToOne
    @JoinColumn(name = "end_planet_id")
    private Planet endPlanet;

    // Додайте інші поля для квитка

    // Геттери та сеттери
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Planet getStartPlanet() {
        return startPlanet;
    }

    public void setStartPlanet(Planet startPlanet) {
        this.startPlanet = startPlanet;
    }

    public Planet getEndPlanet() {
        return endPlanet;
    }

    public void setEndPlanet(Planet endPlanet) {
        this.endPlanet = endPlanet;
    }

    // Додайте інші геттери та сеттери за потребою
}
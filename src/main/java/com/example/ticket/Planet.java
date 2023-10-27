package com.example.ticket;

import javax.persistence.*;
import java.util.List;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "startPlanet", cascade = CascadeType.ALL)
    private List<Ticket> outgoingTickets;

    @OneToMany(mappedBy = "endPlanet", cascade = CascadeType.ALL)
    private List<Ticket> incomingTickets;

    // Геттери та сеттери
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getOutgoingTickets() {
        return outgoingTickets;
    }

    public void setOutgoingTickets(List<Ticket> outgoingTickets) {
        this.outgoingTickets = outgoingTickets;
    }

    public List<Ticket> getIncomingTickets() {
        return incomingTickets;
    }

    public void setIncomingTickets(List<Ticket> incomingTickets) {
        this.incomingTickets = incomingTickets;
    }

    // Додайте інші геттери та сеттери за потребою
}
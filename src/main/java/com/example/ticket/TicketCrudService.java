package com.example.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCrudService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getStartPlanet() == null || ticket.getEndPlanet() == null) {
            throw new IllegalArgumentException("Ticket must have a valid client, start planet, and end planet.");
        }
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if (ticket != null) {
            ticket.setClient(ticketDetails.getClient());
            ticket.setStartPlanet(ticketDetails.getStartPlanet());
            ticket.setEndPlanet(ticketDetails.getEndPlanet());
            // Додайте інші поля, які потрібно оновити
            return ticketRepository.save(ticket);
        }
        return null;
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
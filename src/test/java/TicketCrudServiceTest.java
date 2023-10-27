import com.example.spacetravel.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TicketCrudServiceTest {

    @Autowired
    private ClientCrudService clientCrudService;

    @Autowired
    private PlanetCrudService planetCrudService;

    @Autowired
    private TicketCrudService ticketCrudService;


    @Test
    void testCreateTicketWithValidData() {
        // Створення клієнта та планет
        Client client = new Client();
        client.setName("John Doe");
        client = clientCrudService.createClient(client);

        Planet startPlanet = new Planet();
        startPlanet.setName("Earth");
        startPlanet = planetCrudService.createPlanet(startPlanet);

        Planet endPlanet = new Planet();
        endPlanet.setName("Mars");
        endPlanet = planetCrudService.createPlanet(endPlanet);

        // Створення квитка з правильними даними
        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setStartPlanet(startPlanet);
        ticket.setEndPlanet(endPlanet);

        Ticket createdTicket = ticketCrudService.createTicket(ticket);

        assertNotNull(createdTicket);
        assertNotNull(createdTicket.getId());
    }

    @Test
    void testCreateTicketWithInvalidData() {
        // Створення квитка з нульовим клієнтом
        Ticket ticketWithNullClient = new Ticket();
        ticketWithNullClient.setStartPlanet(new Planet());
        ticketWithNullClient.setEndPlanet(new Planet());

        assertThrows(IllegalArgumentException.class, () -> ticketCrudService.createTicket(ticketWithNullClient));

        // Створення квитка з нульовою початковою планетою
        Ticket ticketWithNullStartPlanet = new Ticket();
        ticketWithNullStartPlanet.setClient(new Client());
        ticketWithNullStartPlanet.setEndPlanet(new Planet());

        assertThrows(IllegalArgumentException.class, () -> ticketCrudService.createTicket(ticketWithNullStartPlanet));

        // Створення квитка з нульовою кінцевою планетою
        Ticket ticketWithNullEndPlanet = new Ticket();
        ticketWithNullEndPlanet.setClient(new Client());
        ticketWithNullEndPlanet.setStartPlanet(new Planet());

        assertThrows(IllegalArgumentException.class, () -> ticketCrudService.createTicket(ticketWithNullEndPlanet));
    }
}
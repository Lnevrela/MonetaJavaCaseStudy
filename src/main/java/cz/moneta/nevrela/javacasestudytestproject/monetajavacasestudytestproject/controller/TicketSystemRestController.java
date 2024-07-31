package cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.controller;

import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.dto.TicketResponseDTO;
import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.entity.Ticket;
import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.service.TicketService;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for managing tickets
 */
@RestController
public class TicketSystemRestController {

    private final TicketService ticketService;

    public TicketSystemRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Get information about active ticket
     * @return Active ticket entity
     */
    @GetMapping(name = "/")
    public Ticket getActiveTicket() {
        Ticket ticket = ticketService.getActiveTicket();
        return ticket;
    }

    /**
     * Create new ticket and return its information
     * @return return TicketResponseDTO containing Ticket entity and its order number
     */
    @PostMapping("/")
    public TicketResponseDTO createTicket() {
        TicketResponseDTO ticketRespone;
        ticketRespone = ticketService.createNewTicket();
        return ticketRespone;
    }

    /**
     * Delete active ticket
     */
    @DeleteMapping("/")
    public void deleteActiveTicket() {
        ticketService.deleteActiveTicket();
    }
}

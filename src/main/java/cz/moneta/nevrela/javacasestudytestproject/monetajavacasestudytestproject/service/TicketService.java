package cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.service;

import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.dto.TicketResponseDTO;
import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.repository.TicketRepository;
import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.entity.Ticket;
import org.springframework.stereotype.Service;

/**
 * Service class that manages creating, getting and deleting tickets.
 */
@Service
public class TicketService {

    private final TicketRepository ticketRepo;

    public TicketService(TicketRepository ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    /**
     * This method create new ticket that will be stored in database.
     * Ticket will have time when was created. And in database will be generated
     * his ID number from sequence
     * @return TicketResponseDTO which contain Ticket entity and ticket order number.
     */
    public TicketResponseDTO createNewTicket() {
        TicketResponseDTO ticketResponse = new TicketResponseDTO(ticketRepo.save(new Ticket()),ticketRepo.countAllBy());
        return ticketResponse;
    }

    /**
     * This method get active ticket from database
     * @return Ticket entity from active ticket
     */
    public Ticket getActiveTicket() {
        return ticketRepo.findFirstByOrderByTicketNumber();
    }


    /**
     * This method delete active ticket from database
     */
    public void deleteActiveTicket() {
        ticketRepo.deleteActiveTicket();
    }
}

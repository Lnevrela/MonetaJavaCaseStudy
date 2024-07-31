package cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject;

import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.dto.TicketResponseDTO;
import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.repository.TicketRepository;
import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.entity.Ticket;
import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.service.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {


    @Mock
    private TicketRepository ticketRepo;
    @InjectMocks
    private TicketService ticketService;
    private Ticket ticket;

    @BeforeEach
    void beforeEach() {
        ticket = new Ticket();
    }

    @Test
    public void createTicketTest() {
        Mockito.when(ticketRepo.save(Mockito.any())).thenReturn(ticket);
        TicketResponseDTO ticketResponse = new TicketResponseDTO(ticket,ticketRepo.countAllBy());
        ticketResponse = ticketService.createNewTicket();
        Assertions.assertEquals(ticket, ticketResponse.ticket());
        Assertions.assertEquals(0, ticketResponse.ticketOrderNumber());
        Mockito.verify(ticketRepo).save(Mockito.any());
    }

    @Test
    public void getActiveTicketTest() {
        Mockito.when(ticketRepo.findFirstByOrderByTicketNumber()).thenReturn(ticket);
        Assertions.assertEquals(0, ticketService.getActiveTicket().getTicketNumber());
        Mockito.verify(ticketRepo).findFirstByOrderByTicketNumber();
    }

    @Test
    public void deleteActiveTicketTest() {
        ticketService.deleteActiveTicket();
        Mockito.verify(ticketRepo).deleteActiveTicket();
    }
}

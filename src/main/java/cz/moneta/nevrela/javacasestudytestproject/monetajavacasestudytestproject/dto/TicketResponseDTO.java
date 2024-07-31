package cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.dto;

import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.entity.Ticket;

public record TicketResponseDTO(Ticket ticket, int ticketOrderNumber) {
}

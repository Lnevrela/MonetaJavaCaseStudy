package cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ticketnumber")
    private int ticketNumber;
    @Column(name = "ticketaccepteddate")
    private OffsetDateTime ticketAcceptedDate;

    public Ticket() {
        this.ticketAcceptedDate = new Date().toInstant().atOffset(ZoneOffset.UTC);
    }
}

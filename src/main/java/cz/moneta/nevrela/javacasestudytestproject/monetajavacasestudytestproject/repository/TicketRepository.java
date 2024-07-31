package cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.repository;


import cz.moneta.nevrela.javacasestudytestproject.monetajavacasestudytestproject.entity.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    int countAllBy();

    Ticket findFirstByOrderByTicketNumber();

    @Transactional
    @Modifying
    @Query("delete from Ticket where ticketNumber = (select ticketNumber from Ticket order by ticketNumber limit 1)")
    void deleteActiveTicket();

}

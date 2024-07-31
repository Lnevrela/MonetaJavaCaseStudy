create sequence ticketNumberSeq start 1 increment 1;

create table if not exists Ticket (
    ticketNumber int default nextval('ticketNumberSeq') primary key,
    ticketAcceptedDate timestamp
)
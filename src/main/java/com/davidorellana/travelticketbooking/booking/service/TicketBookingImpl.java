package com.davidorellana.travelticketbooking.booking.service;

import com.davidorellana.travelticketbooking.booking.model.data.TicketBooking;
import com.davidorellana.travelticketbooking.booking.model.dto.TicketBookingDto;
import com.davidorellana.travelticketbooking.booking.repository.TicketBookingRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketBookingImpl implements TicketBookingService {

    private final TicketBookingRepositoryDao ticketBookingRepositoryDao;

    @Autowired
    public TicketBookingImpl(TicketBookingRepositoryDao ticketBookingRepositoryDao) {
        this.ticketBookingRepositoryDao = ticketBookingRepositoryDao;
    }

    @Override
    public List<TicketBooking> getAllTicketBooking() {
        return ticketBookingRepositoryDao.getAllTicketBooking();
    }

    @Override
    public TicketBooking findTicketBookingById(String id) {
        return ticketBookingRepositoryDao.findTicketBookingById(id);
    }

    @Override
    public TicketBooking createTicketBooking(TicketBookingDto ticketBookingDto) {
        return ticketBookingRepositoryDao.createTicketBooking(ticketBookingDto);
    }

    @Override
    public TicketBooking updatedTicketBookingById(String id, TicketBookingDto ticketBookingDto) {
        return ticketBookingRepositoryDao.updatedTicketBookingById(id, ticketBookingDto);
    }

    @Override
    public Boolean deleteTicketBookingById(String id) {
        return ticketBookingRepositoryDao.deleteTicketBookingById(id);
    }

    @Override
    public Boolean deleteAllTicketBooking() {
        return ticketBookingRepositoryDao.deleteAllTicketBooking();
    }
}

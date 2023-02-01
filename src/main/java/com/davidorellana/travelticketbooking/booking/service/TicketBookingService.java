package com.davidorellana.travelticketbooking.booking.service;

import com.davidorellana.travelticketbooking.booking.model.data.TicketBooking;
import com.davidorellana.travelticketbooking.booking.model.dto.TicketBookingDto;

import java.util.List;

public interface TicketBookingService {

    List<TicketBooking> getAllTicketBooking();
    TicketBooking findTicketBookingById(String id);
    TicketBooking createTicketBooking(TicketBookingDto ticketBookingDto);
    TicketBooking updatedTicketBookingById(String id, TicketBookingDto ticketBookingDto);
    Boolean deleteTicketBookingById(String id);
    Boolean deleteAllTicketBooking();
}

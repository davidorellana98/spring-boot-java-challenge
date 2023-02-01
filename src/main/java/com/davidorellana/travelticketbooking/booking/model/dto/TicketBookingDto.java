package com.davidorellana.travelticketbooking.booking.model.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record TicketBookingDto(
        String name,
        String email,
        List<Integer> numberOfSeats,
        String origin,
        String destination,
        LocalDate departureDate,
        LocalTime departureTime,
        Double estimatedDuration,
        Double unitPrice
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}


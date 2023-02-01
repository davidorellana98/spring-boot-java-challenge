package com.davidorellana.travelticketbooking.booking.repository;

import com.davidorellana.travelticketbooking.booking.model.data.TicketBooking;
import com.davidorellana.travelticketbooking.booking.model.dto.TicketBookingDto;
import com.davidorellana.travelticketbooking.booking.repository.mongorepository.TicketBookingMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TicketBookingRepositoryImpl implements TicketBookingRepositoryDao {

    private final TicketBookingMongoRepository ticketBookingMongoRepository;

    @Autowired
    public TicketBookingRepositoryImpl(TicketBookingMongoRepository ticketBookingMongoRepository) {
        this.ticketBookingMongoRepository = ticketBookingMongoRepository;
    }

    @Override
    public List<TicketBooking> getAllTicketBooking() {
        return ticketBookingMongoRepository.findAll();
    }

    @Override
    public TicketBooking findTicketBookingById(String id) {
        Optional<TicketBooking> ticketBookingByIdFound = ticketBookingMongoRepository.findById(id);
        if (ticketBookingByIdFound.isPresent()) {
            return ticketBookingByIdFound.get();
        }
        return null;
    }

    @Override
    public TicketBooking createTicketBooking(TicketBookingDto ticketBookingDto) {
        boolean startDateCheck = ticketBookingDto.departureDate().isAfter(LocalDate.now().minusDays(1));
        if (startDateCheck) {
            TicketBooking ticketBookingCreated = new TicketBooking(ticketBookingDto);
            return ticketBookingMongoRepository.save(ticketBookingCreated);
        }
        return null;
    }

    @Override
    public TicketBooking updatedTicketBookingById(String id, TicketBookingDto ticketBookingDto) {
        TicketBooking ticketBookingFound = findTicketBookingById(id);
        if (ticketBookingFound != null) {
            boolean startDateCheck = ticketBookingDto.departureDate().isAfter(LocalDate.now().minusDays(1));
            if (startDateCheck) {
                ticketBookingFound.updateTicketBooking(ticketBookingDto);
                return ticketBookingMongoRepository.save(ticketBookingFound);
            }
        }
        return null;
    }

    @Override
    public Boolean deleteTicketBookingById(String id) {
        if (ticketBookingMongoRepository.existsById(id)) {
            ticketBookingMongoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteAllTicketBooking() {
        List<TicketBooking> bookingTicketList = getAllTicketBooking();
        if (!bookingTicketList.isEmpty()) {
            ticketBookingMongoRepository.deleteAll();
            return true;
        }
        return false;
    }
}

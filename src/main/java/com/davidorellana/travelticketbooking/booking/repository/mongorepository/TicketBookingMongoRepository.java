package com.davidorellana.travelticketbooking.booking.repository.mongorepository;

import com.davidorellana.travelticketbooking.booking.model.data.TicketBooking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketBookingMongoRepository extends MongoRepository<TicketBooking, String> { }

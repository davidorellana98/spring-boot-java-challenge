package com.davidorellana.travelticketbooking.booking.controller;

import com.davidorellana.travelticketbooking.booking.model.data.TicketBooking;
import com.davidorellana.travelticketbooking.booking.model.dto.TicketBookingDto;
import com.davidorellana.travelticketbooking.booking.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/ticketBooking")
public class TicketBookingController {

    private final TicketBookingService ticketBookingService;

    @Autowired
    public TicketBookingController(TicketBookingService ticketBookingService) {
        this.ticketBookingService = ticketBookingService;
    }

    @GetMapping
    public ResponseEntity<List<TicketBooking>> getAllTicketBooking() {
        List<TicketBooking> ticketBookingsList = ticketBookingService.getAllTicketBooking();
        if (ticketBookingsList.isEmpty()) {
            return new ResponseEntity("The ticket bookings collection is empty.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketBookingsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketBooking> findTicketBookingById(@PathVariable String id) {
        TicketBooking ticketBookingByIdFound = ticketBookingService.findTicketBookingById(id);
        if (ticketBookingByIdFound != null) {
            return new ResponseEntity<>(ticketBookingByIdFound, HttpStatus.OK);
        }
        return new ResponseEntity("The id " + id + " does not exist in the ticket booking collection.", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TicketBooking> createTicketBooking(@RequestBody TicketBookingDto ticketBookingDto) {
        TicketBooking ticketBookingCreated = ticketBookingService.createTicketBooking(ticketBookingDto);
        if (ticketBookingCreated != null) {
            return new ResponseEntity<>(ticketBookingCreated, HttpStatus.CREATED);
        }
        return new ResponseEntity("Inconsistent dates error, please enter data correctly.", HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketBooking> updatedTicketBookingById(@PathVariable String id, @RequestBody TicketBookingDto ticketBookingDto) {
        TicketBooking ticketBookingUpdated = ticketBookingService.updatedTicketBookingById(id, ticketBookingDto);
        if (ticketBookingUpdated != null) {
            return new ResponseEntity<>(ticketBookingUpdated, HttpStatus.OK);
        }
        return new ResponseEntity("Failed to update, possibly due to inconsistent id or dates.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTicketBookingById(@PathVariable String id){
        if (ticketBookingService.deleteTicketBookingById(id)) {
            return new ResponseEntity("Deleted ticket booking.", HttpStatus.OK);
        }
        return new ResponseEntity("The id " + id + " is not found in the collection of tickets bookings to delete.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity deleteAllTicketBooking() {
        if (ticketBookingService.deleteAllTicketBooking()) {
            return new ResponseEntity("Correct deletion of the entire ticket booking collection.", HttpStatus.OK);
        }
        return new ResponseEntity("There is no collection of tickets bookings to delete.", HttpStatus.NOT_FOUND);
    }
}

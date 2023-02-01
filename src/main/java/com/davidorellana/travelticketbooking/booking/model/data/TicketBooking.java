package com.davidorellana.travelticketbooking.booking.model.data;

import com.davidorellana.travelticketbooking.booking.model.dto.TicketBookingDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Document(collection = "ticket_booking_collection")
public class TicketBooking implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private Integer busNumber;
    private List<Integer> numberOfSeats;
    private Integer amountOfTickets;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;

    private Double estimatedDuration;
    private Double unitPrice;
    private Double totalPrice;

    public TicketBooking() { }

    public TicketBooking(TicketBookingDto ticketBookingDto) {
        updateTicketBooking(ticketBookingDto);
    }

    public void updateTicketBooking(TicketBookingDto ticketBookingDto) {
        this.name = ticketBookingDto.name();
        this.email = ticketBookingDto.email();
        this.busNumber = randomBusNumber();
        this.numberOfSeats = ticketBookingDto.numberOfSeats();
        this.amountOfTickets = numberOfSeats.size();
        this.origin = ticketBookingDto.origin();
        this.destination = ticketBookingDto.destination();
        this.departureDate = ticketBookingDto.departureDate();
        this.departureTime = ticketBookingDto.departureTime();
        this.estimatedDuration = ticketBookingDto.estimatedDuration();
        this.unitPrice = ticketBookingDto.unitPrice();
        this.totalPrice = numberOfSeats.size() * unitPrice;
    }

    public Integer randomBusNumber() {
        Random busNumber = new Random();
        return busNumber.nextInt(5);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(Integer busNumber) {
        this.busNumber = busNumber;
    }

    public List<Integer> getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(List<Integer> numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getAmountOfTickets() {
        return amountOfTickets;
    }

    public void setAmountOfTickets(Integer amountOfTickets) {
        this.amountOfTickets = amountOfTickets;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public Double getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(Double estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "TicketBooking{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", busNumber=" + busNumber +
                ", numberOfSeats=" + numberOfSeats +
                ", amountOfTickets=" + amountOfTickets +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", estimatedDuration=" + estimatedDuration +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketBooking that = (TicketBooking) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(busNumber, that.busNumber) && Objects.equals(numberOfSeats, that.numberOfSeats) && Objects.equals(amountOfTickets, that.amountOfTickets) && Objects.equals(origin, that.origin) && Objects.equals(destination, that.destination) && Objects.equals(departureDate, that.departureDate) && Objects.equals(departureTime, that.departureTime) && Objects.equals(estimatedDuration, that.estimatedDuration) && Objects.equals(unitPrice, that.unitPrice) && Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, busNumber, numberOfSeats, amountOfTickets, origin, destination, departureDate, departureTime, estimatedDuration, unitPrice, totalPrice);
    }
}

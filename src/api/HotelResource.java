package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class HotelResource  {
    Reservation reservation;
    CustomerService customerService;
    Calendar calendar = Calendar.getInstance();
    Date date= new Date();

    ReservationService reservationService = new ReservationService();
    List<Reservation> reservationList;

    public Collection<Reservation> getCustomersReservations(Date checkIn, Date checkOut){
        Scanner sc = new Scanner(System.in);
        for (Reservation reservationPnt: reservationList
             ) {
            System.out.println(reservationPnt.getCheckInDate().equals(checkIn));
            System.out.println(reservationPnt.getCheckOutDate().equals(checkOut));
        }

        return null;
    }

    public Customer getCustomer(String email){
      return  customerService.getCustomer(email);

    }

    public void createACustomer(String email,String firstName, String lastName){
        customerService.addCustomer(email,firstName,lastName);
    }

    public IRoom getRoom(String roomNumber){
     return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate,Date checkOutDate){

        return reservationService.reserveARoom(getCustomer(customerEmail),room,checkInDate,checkOutDate);


    }


}

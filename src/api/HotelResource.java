package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelResource  {




    CustomerService customerService = new CustomerService();
    Calendar calendar = Calendar.getInstance();
    Date date= new Date();
    String firstName;
    String lastName;
    String email;
    Date checkInDate;
    Date checkOutDate;

    Room room = new Room();


    ReservationService reservationService = new ReservationService();
    List<Reservation> reservationList = new ArrayList<Reservation>();



    public Collection<Reservation> getCustomersReservations(Date checkIn, Date checkOut){
        Scanner sc = new Scanner(System.in);

        for (Reservation reservationPnt: reservationList
             ) {
            for(Date date = checkIn;date.after(checkIn);date = checkOut){
                System.out.println(reservationPnt);
            }
            System.out.println(reservationPnt);
            return reservationList;
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
        String emailRegex="^(.+)@(.+).(.+)$";

        Pattern emailRegExPattern= Pattern.compile(emailRegex);
        Matcher emailPatternMatcher = emailRegExPattern.matcher(customerEmail);

        if(emailPatternMatcher.matches()){
            this.email = customerEmail;
        }else{
            throw new IllegalArgumentException("Invalid format");
        }

        Customer customer = new Customer(firstName,lastName,email);
        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);

             reservation.setCheckInDate(checkInDate);
             reservation.setCheckOutDate(checkOutDate);
             reservation.setRoom(room);
             reservation.setCustomer(customerService.getCustomer(customerEmail));
             reservationList.add(reservation);

        return reservationService.reserveARoom(getCustomer(customerEmail),room,checkInDate,checkOutDate);


    }


}

package service;

import model.IRoom;
import model.Room;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ServiceTester {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        customerService.addCustomer("j@d.com","Jad","Rad");


        //System.out.println(customerService.getCustomer("j@d.com"));
        //System.out.println(customerService.getAllCustomers());

        Scanner sc = new Scanner(System.in);
        Room room1 = new Room();
        IRoom room = new Room();

        Date newCheckInDate = new Date();
        Date newCheckOutDate = new Date();
        String checkInString = "08 04 2022";
        String checkOutString = "08 04 2022";
        DateFormat formatter= new SimpleDateFormat("dd MM yyyy");
        ReservationService reservationService = new ReservationService();


        try {
            newCheckInDate = formatter.parse(checkInString);
            newCheckOutDate = formatter.parse(checkOutString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //System.out.println(CustomerService.CustomerList);
        CustomerService.getAllCustomers();

       //reservationService.addRoom(room1);
           // customerService.getCustomer("j@d.com");
      // reservationService.reserveARoom(customerService.getCustomer("j@d.com"),reservationService.getARoom("123"),newCheckInDate,newCheckOutDate);
    }

}

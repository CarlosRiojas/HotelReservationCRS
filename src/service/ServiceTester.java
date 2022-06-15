package service;

import model.IRoom;
import model.Room;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        ReservationService reservationService = new ReservationService();
        Calendar checkIn = Calendar.getInstance();
        Calendar checkOut = Calendar.getInstance();

        Date newCheckInDate = new Date();
        Date newCheckOutDate = new Date();
        String checkInString = "2022,04,05";
        String checkOutString = "08 04 2022";

        checkIn.set(2022,02,02);
        checkOut.set(2022,02,06);

        newCheckInDate = checkIn.getTime();
        newCheckOutDate = checkOut.getTime();
        //reservationService.addRoom(room1);
        customerService.getCustomer("j@d.com");

        //System.out.println(CustomerService.CustomerList);
       // CustomerService.getAllCustomers();

           // customerService.getCustomer("j@d.com");
        reservationService.addRoom(room1);
        reservationService.reserveARoom(customerService.getCustomer("j@d.com"),reservationService.getARoom("123"),newCheckInDate,newCheckOutDate);
    }

}

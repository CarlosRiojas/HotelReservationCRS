package service;

import model.Room;

import java.util.Scanner;

public class ServiceTester {
    public static void main(String[] args) {
        /*CustomerService customerService = new CustomerService();
        customerService.addCustomer("j@d.com","Jad","Rad");
        customerService.addCustomer("bud@d.com","Buddy","Price");
        customerService.addCustomer("Chris@d.com","Chris","White");


        System.out.println(customerService.getCustomer("j@d.com"));
        System.out.println(customerService.getAllCustomers());
        */
        Scanner sc = new Scanner(System.in);
        Room room1 = new Room();
        ReservationService reservationService = new ReservationService();
        reservationService.addRoom(room1);

    }

}

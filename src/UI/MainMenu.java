package UI;


import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.nio.channels.SelectableChannel;
import java.util.*;

public class MainMenu {

    AdminMenu ToAdminMenu = new AdminMenu();

    Date date = new Date();
    Calendar CheckIncalendar = Calendar.getInstance();
    Calendar CheckOutcalendar = Calendar.getInstance();
    Calendar BookCheckIn = Calendar.getInstance();
    Calendar BookCheckOut = Calendar.getInstance();
    IRoom room =new Room();
    Scanner sc = new Scanner(System.in);
    Scanner InputString = new Scanner(System.in);
    List<Customer> CustomerList = new ArrayList<>();
    CustomerService customerService = new CustomerService();
    ReservationService reservationService = new ReservationService();
    AdminResource adminResource = new AdminResource();
    HotelResource hotelResource = new HotelResource();

    //int yearInt = sc.nextInt();
    //int monthInt = sc.nextInt();
    //int dayInt = sc.nextInt();
    //int resYearInt = sc.nextInt();
    //int resMonthInt = sc.nextInt();
   // int resDayInt = sc.nextInt();


    public void mainMenu(){

        boolean quit = false;

        while(!quit) {
            System.out.println("*---------BW Master Booker------------*");
            System.out.println("*--------------Welcome!-------------*");
            System.out.println("1.- Find and reserve a room");
            System.out.println("2.- See my reservations");
            System.out.println("3.- Admin menu");
            System.out.println("4.- Quit app");
            System.out.println("");
            System.out.println("*-------Type IN your option below:-----*");

            Scanner sc = new Scanner(System.in);
            Scanner InputString = new Scanner(System.in);

            String emailInput;

            IRoom roomInput = new Room();

            //int selection = sc.nextInt();
            switch(sc.nextInt()){
                case 1:

                    System.out.println("*---------Find a Room-------------*");
                    System.out.println("*---------Enter a room number-------------*");
                    hotelResource.getRoom(InputString.nextLine());


                    System.out.println("*---------Reserve a Room-------------*");
                    System.out.println("Please add customer's E-mail: ");
                    emailInput = InputString.nextLine();

                    if(!CustomerList.isEmpty()){
                        CustomerList.add(hotelResource.getCustomer(emailInput));
                    }else{
                        System.out.println("Please add the customer(Email,firstname,lastname:");
                        hotelResource.createACustomer(InputString.nextLine(),InputString.nextLine(),InputString.nextLine());
                    }

                    System.out.println("Please add desired room: ");
                        adminResource.getAllRooms();
                    System.out.println("Which room would you like to add: ");
                         roomInput= hotelResource.getRoom(InputString.nextLine());

                    System.out.println("Please add desired Check OUT date(YYYY MM DD): ");
                    //BookCheckIn.set(resYearInt,resMonthInt,resDayInt);
                    BookCheckIn.set(sc.nextInt(),sc.nextInt(),sc.nextInt());
                    Date resCheckOutDate = BookCheckOut.getTime();

                    System.out.println("Please add desired Check In date(YYYY MM DD): ");
                    BookCheckIn.set(sc.nextInt(),sc.nextInt(),sc.nextInt());
                    Date resCheckInDate = BookCheckIn.getTime();

                    hotelResource.bookARoom(emailInput,roomInput,resCheckOutDate,resCheckInDate);
                    mainMenu();
                case 2:
                    System.out.println("*---------All Reservations-------------*");
                    System.out.println("Add check IN date(YYYY MM DD): ");
                    CheckIncalendar.set(sc.nextInt(),sc.nextInt(),sc.nextInt());
                    Date CheckInDate = CheckIncalendar.getTime();


                    System.out.println("*---------------------------------*");
                    System.out.println("Add check OUT date(YYYY MM DD): ");
                    CheckOutcalendar.set(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    Date CheckOutDate = CheckOutcalendar.getTime();

                    hotelResource.getCustomersReservations(CheckInDate,CheckOutDate);
                    mainMenu();
                case 3:
                    ToAdminMenu.adminMenu();
                case 4:
                    break;

            }


        }
    }

}

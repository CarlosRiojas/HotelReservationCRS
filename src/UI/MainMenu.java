package UI;


import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;

import java.util.*;

/*
Here's the main menu, as you can see differently from Admin menu, there are more switchers here
due to the fact that it wasn't clear what it was supposed to be asked in some of the options.
 */
public class MainMenu {

    AdminMenu ToAdminMenu = new AdminMenu();

    Calendar CheckIncalendar = Calendar.getInstance();
    Calendar CheckOutcalendar = Calendar.getInstance();
    Calendar BookCheckIn = Calendar.getInstance();
    Calendar BookCheckOut = Calendar.getInstance();
    List<Customer> customerList = new ArrayList<>();

    AdminResource adminResource = new AdminResource();
    HotelResource hotelResource = new HotelResource();


    public void mainMenu(){

        boolean quit = false;

        while(!quit) {
            System.out.println("*---------BW Master Booker------------*");
            System.out.println("*--------------Welcome!-------------*");
            System.out.println("1.- Find and reserve a room");
            System.out.println("2.- See my reservations");
            System.out.println("3.- Admin menu");
            System.out.println("4-  Create an Account");
            System.out.println("5-  Quit");
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
                    emailInput = sc.next();


                            if (!adminResource.getAllCustomers().isEmpty()) {
                                System.out.println("there are customers");
                                for(Customer customer: adminResource.getAllCustomers()) {
                                    if(customer.getEmail().contains(emailInput)) {
                                        System.out.println(customer + " identified");

                                        //continue the booking process
                                        System.out.println("Please add desired room: ");
                                        adminResource.getAllRooms();
                                        System.out.println("Which room would you like to add: ");
                                        roomInput = hotelResource.getRoom(InputString.nextLine());

                                        System.out.println("Please add desired Check OUT date(YYYY MM DD): ");
                                        //BookCheckIn.set(resYearInt,resMonthInt,resDayInt);
                                        BookCheckIn.set(sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        Date resCheckOutDate = BookCheckOut.getTime();

                                        System.out.println("Please add desired Check In date(YYYY MM DD): ");
                                        BookCheckIn.set(sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        Date resCheckInDate = BookCheckIn.getTime();

                                       hotelResource.bookARoom(emailInput, roomInput, resCheckOutDate, resCheckInDate);

                                        mainMenu();
                                        }
                                    }
                            } else {
                                System.out.println("There is no customer with that email");
                                mainMenu();
                    }

                case 2:
                    System.out.println("*---------All Reservations-------------*");
                    System.out.println("Add check IN date(YYYY MM DD): ");
                    CheckIncalendar.set(sc.nextInt(),sc.nextInt(),sc.nextInt());
                    Date CheckInDate = CheckIncalendar.getTime();

                    /*I had no clue how
                      to make format better in the input phase, at least not bothering
                     while having to solve bugs.
                     */

                    System.out.println("*---------------------------------*");
                    System.out.println("Add check OUT date(YYYY MM DD): ");
                    CheckOutcalendar.set(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    Date CheckOutDate = CheckOutcalendar.getTime();

                    hotelResource.getCustomersReservations(CheckInDate,CheckOutDate);
                    mainMenu();
                case 3:
                    ToAdminMenu.adminMenu();
                case 4:
                    System.out.println("*---------------------------------*");
                    System.out.println("*-----Create an Account------------");


                    System.out.println("*-----please add an email------------");
                    String email=sc.next();

                    System.out.println("*-----please add an First Name------------");
                    String firstName=sc.next();

                    System.out.println("*-----please add an Last Name------------");
                    String lastName=sc.next();

                    hotelResource.createACustomer(email,firstName,lastName);

                    mainMenu();
                case 5:
                    break;
            }


        }
    }

}

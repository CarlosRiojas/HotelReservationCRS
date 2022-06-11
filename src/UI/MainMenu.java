package UI;


import api.HotelResource;
import model.IRoom;
import model.Room;

import java.nio.channels.SelectableChannel;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    AdminMenu ToAdminMenu = new AdminMenu();
    HotelResource hotelResource = new HotelResource();
    Date date = new Date();
    Calendar CheckIncalendar = Calendar.getInstance();
    Calendar CheckOutcalendar = Calendar.getInstance();
    Calendar BookCheckIn = Calendar.getInstance();
    Calendar BookCheckOut = Calendar.getInstance();
    IRoom room =new Room();




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

            int selection = sc.nextInt();
            int yearInt = sc.nextInt();
            int monthInt = sc.nextInt();
            int dayInt = sc.nextInt();

            String emailInput;
            String findAroom = InputString.nextLine();

            IRoom roomInput = new Room();
            int resYearInt = sc.nextInt();
            int resMonthInt = sc.nextInt();
            int resDayInt = sc.nextInt();


            switch(selection){
                case 1:


                    System.out.println("*---------Find a Room-------------*");
                    hotelResource.getRoom(findAroom);

                    System.out.println("*---------Reserve a Room-------------*");
                    System.out.println("Please add customer's E-mail: ");
                    emailInput = InputString.nextLine();


                    System.out.println("Please add desired room: ");
                    roomInput.getRoomNumber().equals(InputString.nextLine());

                    System.out.println("Please add desired Check OUT date(YYYY MM DD): ");
                    BookCheckIn.set(resYearInt,resMonthInt,resDayInt);
                    Date resCheckOutDate = BookCheckOut.getTime();

                    System.out.println("Please add desired Check In date(YYYY MM DD): ");
                    BookCheckIn.set(resYearInt,resMonthInt,resDayInt);
                    Date resCheckInDate = BookCheckIn.getTime();

                    hotelResource.bookARoom(emailInput,roomInput,resCheckOutDate,resCheckInDate);

                case 2:
                    System.out.println("*---------All Reservations-------------*");
                    System.out.println("Add check IN date(YYYY MM DD): ");
                    CheckIncalendar.set(yearInt,monthInt,dayInt);
                    Date CheckInDate = CheckIncalendar.getTime();

                    System.out.println("*---------------------------------*");
                    System.out.println("Add check OUT date(YYYY MM DD): ");
                    CheckOutcalendar.set(yearInt, monthInt, dayInt);
                    Date CheckOutDate = CheckOutcalendar.getTime();
                    hotelResource.getCustomersReservations(CheckInDate,CheckOutDate);

                case 3:
                    ToAdminMenu.adminMenu();
                case 4:
                    break;

            }


        }
    }

}

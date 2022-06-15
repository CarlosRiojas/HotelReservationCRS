package UI;

import api.AdminResource;
import model.IRoom;
import model.Room;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    public void adminMenu() {
        AdminResource adminResource = new AdminResource();
        MainMenu mainMenu = new MainMenu();
        Room roomInsert = new Room();
        List<IRoom> roomList;
        Scanner sc = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {

            System.out.println("*-------------BW Master Booker-------------*");
            System.out.println("*--------------Welcome Admin!-------------*");
            System.out.println("1.- See all Customers");
            System.out.println("2.- See all Rooms");
            System.out.println("3.- See all Reservations");
            System.out.println("4.- Add a Room");
            System.out.println("5.- Back to Main Menu");
            System.out.println("6.- Quit app");
            System.out.println("");
            System.out.println("*-------Type IN your option below:-----*");


            switch (sc.nextInt()){
                case 1:
                    System.out.println("-----Here are all the customers-----");
                    adminResource.getAllCustomers();
                    adminMenu();

                case 2:
                    adminResource.getAllRooms();
                    adminMenu();
                case 3:
                    adminResource.displayAllReservations();
                    adminMenu();
                case 4:
                    int selectIn= sc.nextInt();
                    System.out.println("---Add a Room---");
                    do{
                        System.out.println("----Would you like to add a room?----");
                        System.out.println("1.-Yes 2.-No(go back to admin menu: ");
                        switch (selectIn){
                            case 1:
                                adminResource.addRoom((List<IRoom>) roomInsert);
                            case 2:
                                adminMenu();
                        }
                    }while(selectIn != 2);

                case 5:
                    mainMenu.mainMenu();
                default:
                    break;


            }

        }
    }




}

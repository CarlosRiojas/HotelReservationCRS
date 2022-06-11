package UI;

import java.util.Scanner;

public class AdminMenu {

    public void adminMenu() {
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        boolean quit = false;

        while (!quit) {

            System.out.println("*--------------Welcome Admin!-------------*");
            System.out.println("1.- See all Customers");
            System.out.println("2.- See all Rooms");
            System.out.println("3.- See all Reservations");
            System.out.println("4.- Add a Room");
            System.out.println("5.- Back to Main Menu");
            System.out.println("6.- Quit app");
            System.out.println("");
            System.out.println("*-------Type IN your option below:-----*");


            switch (selection){
                case 1:

            }

        }
    }




}

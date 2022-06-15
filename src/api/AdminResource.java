package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class AdminResource {
    Customer customer;
    Scanner sc = new Scanner(System.in);
    Reservation reservation;
    IRoom room;

    Collection<Room> roomList = new HashSet<Room>();

    List<Customer> customerList;
    CustomerService customerService = new CustomerService();
    ReservationService reservationService = new ReservationService();


    public Customer getCustomer(String email){

        customer = customerService.getCustomer(email);

        return customer;
    }

    public void addRoom(List<IRoom> rooms){

        System.out.println("Add a room number:");
        //(rooms).setRoomNumber(sc.next());
        System.out.println("Add " + (room.getRoomNumber() + " price:"));
        ((Room) room).setPrice(sc.nextDouble());
        System.out.println("Add an Room TYPE type(1.Single,2.Double):");
        ((Room) room).setEnumartion(setEnumeration(sc.next()));
        rooms.add(room);
        System.out.println(room + " room added");

    }

    public RoomTypeEnum setEnumeration(String roomType){
        Room room = new Room();//this may be unnecessary.
        RoomTypeEnum roomTypeEnumSINGLE = RoomTypeEnum.SINGLE;
        RoomTypeEnum roomTypeEnumDOUBLE = RoomTypeEnum.DOUBLE;
        switch (roomType){
            case "1":
                return roomTypeEnumSINGLE;
            case "2":
                return roomTypeEnumDOUBLE;
            default:
                System.out.println("Invalid selection,try again.");
                break;
        }
        return room.getRoomType();

    }


    public Collection<IRoom> getAllRooms(){

       if(!roomList.isEmpty()){
           System.out.println("---Here are all the Rooms---");
           for (Room room: roomList
                ) {

               System.out.println(room);
               return (Collection<IRoom>) room;
           }

       }else{
           System.out.println("No rooms added");
           return null;
       }
    return null;
    }

    public  Collection<Customer> getAllCustomers(){

        return customerService.getAllCustomers();
    }

    public void displayAllReservations(){
            reservationService.printAllReservation();
    }
}

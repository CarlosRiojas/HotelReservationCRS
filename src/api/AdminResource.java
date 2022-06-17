package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.*;


public class AdminResource {
    Customer customer;
    Scanner sc = new Scanner(System.in);
    Reservation reservation;

    IRoom room2= new Room();

    static Collection<IRoom> roomList = new HashSet<IRoom>();

    List<Customer> customerList;
    CustomerService customerService = new CustomerService();
    ReservationService reservationService = new ReservationService();
    List<ReservationService> reservationServiceList = new ArrayList<>();

    List<IRoom> getRoomCollector;

    public Customer getCustomer(String email){

        customer = customerService.getCustomer(email);

        return customer;
    }

    public void addRoom(List<IRoom> rooms){

        reservationService.addRoom(room2);
        System.out.println(reservationService);
        roomList.add(room2);
        rooms.add(reservationService.getARoom(String.valueOf(room2)));


        //ystem.out.println("Add a room number:");
        //((Room) room).setRoomNumber(sc.next());

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
           for (IRoom room: roomList
                ) {
               System.out.println(room);
            return roomList;
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

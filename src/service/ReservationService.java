package service;

import model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationService  {
    Room newRoom = new Room();
    Scanner sc = new Scanner(System.in);
    CustomerService customerService = new CustomerService();
    Calendar calendar = Calendar.getInstance();


    Collection<Room> roomList = new HashSet<Room>();
    Collection<Reservation> reservationList = new HashSet<>();


   public void addRoom(IRoom room) {
       System.out.println("Add a room number:");
       ((Room) room).setRoomNumber(sc.next());
       System.out.println("Add " + (room.getRoomNumber() + " price:"));
       ((Room) room).setPrice(sc.nextDouble());
       System.out.println("Add an Room TYPE type(1.Single,2.Double):");
       ((Room) room).setEnumartion(setEnumeration(sc.next()));
       roomList.add((Room) room);
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

   public IRoom getARoom(String roomId){
       for (Room room: roomList
            ) {
           if(room.getRoomNumber().equals(roomId) || !room.isFree()){
               return room;
           }else{
               System.out.println("Room not found");
               for (Room allRoom: roomList
                    ) {
                   if(allRoom.isFree()) {
                       System.out.println(allRoom.isFree());
                   }else{
                       System.out.println("No accommodations available");
                   }
               }
           }
       }
       return null;
   }

   public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
       //initiate the "Reservation" instance
       Reservation newReservation = new Reservation(customer,room,checkInDate,checkOutDate);
       //These are all scanning variables
        Scanner sc= new Scanner(System.in);
        Scanner dateSc = new Scanner(System.in);

        //Set up the reservation
      // System.out.println("Which customer would you like to add? (type the email): ");
       //customerService.getCustomer("j@d.com");
      newReservation.setCustomer(customer);

       // System.out.println("And in which room will you be accommodating him/her?: ");
        //newReservation.setRoom(getARoom(sc.nextLine()));
       newReservation.setRoom(room);
       //System.out.println("When will the customer be CHECKING IN?: ");
        newReservation.setCheckInDate(checkInDate);//dateString already asks for input

      // System.out.println("When will the customer be CHECKING OUT?: ");
       newReservation.setCheckOutDate(checkOutDate);//dateString already asks for input

        reservationList.add(newReservation);
       System.out.println(newReservation);


    return newReservation;
   }



   public void printAllReservation(){
       if(!reservationList.isEmpty()){
           for (Reservation reservation: reservationList
           ) {
               System.out.println("Customer "+reservation.getCustomer()+", Room: "+reservation.getRoom()+", Check In date: "+reservation.getCheckInDate()+",Check OUT date: "+reservation.getCheckOutDate());
           }
       }else{
           System.out.println("There are NO reservations booked!");
       }
   }


}

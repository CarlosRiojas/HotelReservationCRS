package service;

import model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationService  {
    Room newRoom = new Room();
    CustomerService customerService = new CustomerService();

    public void setNewRoom(Room newRoom) {
        this.newRoom = newRoom;
    }


    Collection<Room> roomList = new HashSet<Room>();
    Collection<Reservation> reservationList = new HashSet<>();

   public void addRoom(IRoom room){
       boolean quit= false;
       Scanner sc = new Scanner(System.in);


           setNewRoom((Room) room);
           System.out.println("Add a room number:");
            ((Room) room).setRoomNumber(sc.next());
           System.out.println("Add "+(room.getRoomNumber()+" price:"));
           ((Room) room).setPrice(sc.nextDouble());
           System.out.println("Add "+(room.getRoomNumber()+" type"));
           ((Room)room).setEnumartion(setEnumeration(sc.nextLine()));



       roomList.add((Room) room);
       System.out.println(room + " room added");
   }

    public RoomTypeEnum setEnumeration(String roomType){
        if(roomType == "2"){
            roomType.equals(RoomTypeEnum.DOUBLE);
        }else if(roomType == "1"){
            roomType.equals(RoomTypeEnum.SINGLE);
        }else{
            System.out.println("Not a valid room type");
        }

        return null;
    }

   public IRoom getARoom(String roomId){
       for (Room room: roomList
            ) {
           if(room.getRoomNumber().equals(roomId) || !room.isFree()){
               return room;
           }else{
               System.out.println("Room not found");
           }
       }
       return null;
   }

   public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
       //initiate the "Reservation" instance
       Reservation newReservation = new Reservation(customer,room,checkInDate,checkOutDate);
       customerService.addCustomer("j@d.com","Jad","Rad");
       //These are all scanning variables
        Scanner sc= new Scanner(System.in);
        Scanner dateSc = new Scanner(System.in);
        dateSc.useDelimiter(",");
        String dateString = dateSc.next();
        DateFormat formatter= new SimpleDateFormat("dd MM yyyy");

        /* Parse the input since Data doesn't take input natively.
        The exception thingy was asked by the Date class itself...just left it there in case
        an error comes up.
         */

       try {
           checkInDate = formatter.parse(dateString);
           checkOutDate = formatter.parse(dateString);
       } catch (ParseException e) {
           e.printStackTrace();
       }
        //Set up the reservation
      // System.out.println("Which customer would you like to add? (type the email): ");
       //customerService.getCustomer("j@d.com");
       newReservation.setCustomer(customerService.getCustomer(customer.getEmail()));

       // System.out.println("And in which room will you be accommodating him/her?: ");
        //newReservation.setRoom(getARoom(sc.nextLine()));
       newReservation.setRoom(room);
       //System.out.println("When will the customer be CHECKING IN?: ");
        newReservation.setCheckInDate(checkInDate);//dateString already asks for input

      // System.out.println("When will the customer be CHECKING OUT?: ");
       newReservation.setCheckOutDate(checkOutDate);//dateString already asks for input

        reservationList.add(newReservation);

       for (Reservation reservKey: reservationList
       ) {
           System.out.println(reservKey.getRoom());
       }

    return newReservation;
   }



   public void printAllReservation(){

   }


}

package service;

import model.*;

import java.util.*;

public class ReservationService  {
    Room newRoom = new Room();

    public void setNewRoom(Room newRoom) {
        this.newRoom = newRoom;
    }


    Collection<Room> roomList = new HashSet<Room>();


   public void addRoom(IRoom room){
       boolean quit= false;
       Scanner sc = new Scanner(System.in);

       while(!quit) {
           setNewRoom((Room) room);
           System.out.println("Add a room number:");
            ((Room) room).setRoomNumber(sc.next());
           System.out.println("Add "+(room.getRoomNumber()+" price:"));
           ((Room) room).setPrice(sc.nextDouble());
           System.out.println("Add "+(room.getRoomNumber()+" type"));
           ((Room)room).setEnumartion(setEnumeration(sc.nextLine()));

       }

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
/*
   public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

   }

 */

   public void printAllReservation(){

   }


}

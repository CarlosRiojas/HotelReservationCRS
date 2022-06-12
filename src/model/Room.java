package model;

import java.util.Scanner;

public class Room implements IRoom {
    String roomNumber;
    Double price;
    RoomTypeEnum enumartion;
    Scanner sc = new Scanner(System.in);

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEnumartion(RoomTypeEnum enumartion) {
        this.enumartion = enumartion;

    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomTypeEnum getRoomType() {
        return enumartion;
    }

    @Override
    public boolean isFree() {
        System.out.println("Occupied");
        return false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", enumartion=" + enumartion +
                '}';
    }
}

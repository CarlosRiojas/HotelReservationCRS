package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    Customer customer;
    Reservation reservation;
    IRoom room;


    List<IRoom> roomList;
    List<Customer> customerList;
    CustomerService customerService = new CustomerService();
    ReservationService reservationService = new ReservationService();


    public Customer getCustomer(String email){

        customer = customerService.getCustomer(email);

        return customer;
    }

    public void addRoom(List<IRoom> rooms){
    reservationService.addRoom(room);
    roomList.add(room);
     rooms.add(room);

    }

    public Collection<IRoom> getAllRooms(){
        for (IRoom room: roomList
             ) {
            return roomList;
        }
        return null;
    }

    public  Collection<Customer> getAllCustomers(){

        return CustomerService.getAllCustomers();
    }

    public void displayAllReservations(){
            reservationService.printAllReservation();
    }
}

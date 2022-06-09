package service;

import model.Customer;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService {
    private static String email;
    private static String firstName;
    private static String lastName;


        static List<Customer> CustomerList = new <Customer>ArrayList();

    public void addCustomer(String email, String firstName, String lastName){
        Customer custInfo = new Customer(firstName,lastName,email);
        custInfo.setEmail(email);
        custInfo.setFirstName(firstName);
        custInfo.setLastName(lastName);
        CustomerList.add(custInfo);
    }

    public Customer getCustomer(String customerEmail){
        for (Customer customer: CustomerList
             ) {

            System.out.println(customer);

            if(CustomerList.contains(customer.getEmail().equals(customerEmail))){
                System.out.println("--------------");
                System.out.println(customer.getLastName() +","+ customer.getFirstName()+", email:"+ customer.getEmail());
                System.out.println("--------------");
                 }else{
                System.out.println("Customer not found");
               }
            }

        return null;
    }

    public static Collection<Customer> getAllCustomers() {
        for (Customer customer: CustomerList
             ) {
            System.out.println(customer.getLastName() +","+ customer.getFirstName()+" | email:"+ customer.getEmail());
            System.out.println("--------------");

        }
        return null;
    }

}

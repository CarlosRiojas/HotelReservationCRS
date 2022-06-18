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


        static List<Customer> customerList = new <Customer>ArrayList();


    public void addCustomer(String email, String firstName, String lastName){
        Customer custInfo = new Customer(lastName,firstName,email);
        custInfo.setEmail(email);
        custInfo.setFirstName(firstName);
        custInfo.setLastName(lastName);
        customerList.add(custInfo);
        System.out.println(customerList);
    }

    public Customer getCustomer(String customerEmail) {

        if (!customerList.isEmpty()) {
            for (Customer customer : customerList
            ) {

                    System.out.println(customer.getLastName() + "," + customer.getFirstName() + ", email:" + customer.getEmail());
                    System.out.println("--------------");
                    return customer;

            }

        } else {
            System.out.println("Customer is not there");
        }
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        if(!customerList.isEmpty()){
            for (Customer customer: customerList
            ) {
                System.out.println(customer.getLastName() +","+ customer.getFirstName()+" | email:"+ customer.getEmail());
                System.out.println("--------------");
                return customerList;
            }
        }else{
            System.out.println("There are no customers!");
            return null;
        }
        return null;
    }

}

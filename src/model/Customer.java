package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    String firstName;
    String lastName;
    String email;

    public Customer(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        String emailRegex="^(.+)@(.+).(.+)$";

        Pattern emailRegExPattern= Pattern.compile(emailRegex);
        Matcher emailPatternMatcher = emailRegExPattern.matcher(email);

               if(emailPatternMatcher.matches()){
                   this.email = email;
               }else{
                   throw new IllegalArgumentException("Invalid format");
               }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

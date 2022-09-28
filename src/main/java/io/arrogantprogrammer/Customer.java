package io.arrogantprogrammer;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends PanacheEntity {

    String email;

    String firstName;

    String lastName;

    CustomerLoyaltyStatus customerLoyaltyStatus;

    static Customer createFromValues(final String email, final String firstName, final String lastName) {

        Customer customer = new Customer();
        customer.email = email;
        customer.firstName = firstName;
        customer.lastName = lastName;

        if(customer.getFirstName().equals("Jeremy")){
            customer.customerLoyaltyStatus = CustomerLoyaltyStatus.VIP;
        }else if(customer.getFirstName().equals("Robert")) {
            customer.customerLoyaltyStatus = CustomerLoyaltyStatus.NOT_THAT_GUY_AGAIN;
        }else{
            customer.customerLoyaltyStatus = CustomerLoyaltyStatus.UNKNOWN;
        }

        return customer;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerLoyaltyStatus=" + customerLoyaltyStatus +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerLoyaltyStatus getCustomerLoyaltyStatus() {
        return customerLoyaltyStatus;
    }
}

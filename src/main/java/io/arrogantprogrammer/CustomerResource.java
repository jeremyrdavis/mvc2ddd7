package io.arrogantprogrammer;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/customers")
public class CustomerResource {


    @GET
    public List<Customer> allCustomers() {

        return Customer.listAll();
    }

    @POST
    @Transactional
    public Customer addCustomer(Customer customer) {

        if(customer.getFirstName().equals("Jeremy")){
            customer.customerLoyaltyStatus = CustomerLoyaltyStatus.VIP;
        }else if(customer.getFirstName().equals("Robert")) {
            customer.customerLoyaltyStatus = CustomerLoyaltyStatus.NOT_THAT_GUY_AGAIN;
        }else{
            customer.customerLoyaltyStatus = CustomerLoyaltyStatus.UNKNOWN;
        }
        customer.persist();
        return customer;

    }
}

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
    public Customer addCustomer(Customer customerToCreate) {

        Customer customer = Customer.createFromValues(customerToCreate.getEmail(), customerToCreate.getFirstName(), customerToCreate.getLastName());
        customer.persist();
        return customer;

    }
}

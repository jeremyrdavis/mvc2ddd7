package io.arrogantprogrammer;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @GET
    public List<Customer> allCustomers() {

        return customerRepository.listAll();
    }

    @POST
    @Transactional
    public Customer addCustomer(Customer customerToCreate) {

        Customer customer = Customer.createFromValues(customerToCreate.getEmail(), customerToCreate.getFirstName(), customerToCreate.getLastName());
        customerRepository.persist(customer);
        return customer;

    }
}

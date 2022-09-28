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
    public CustomerRecord addCustomer(CustomerRecord customerRecord) {

        Customer customer = Customer.createFromValues(customerRecord.email(), customerRecord.firstName(), customerRecord.lastName());
        customerRepository.persist(customer);
        return new CustomerRecord(customer.id, customer.getEmail(), customer.getFirstName(), customer.getLastName(), customer.getCustomerLoyaltyStatus());

    }
}

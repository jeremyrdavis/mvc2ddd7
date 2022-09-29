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
    CustomerService customerService;

    @GET
    public List<CustomerRecord> allCustomers() {

        return customerService.allCustomers();
    }

    @POST
    @Transactional
    public CustomerRecord addCustomer(CustomerRecord customerRecord) {

        return customerService.addCustomer(customerRecord);
    }
}

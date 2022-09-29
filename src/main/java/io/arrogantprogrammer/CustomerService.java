package io.arrogantprogrammer;

import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public List<CustomerRecord> allCustomers() {

        return customerRepository.listAll().stream().map(customer -> {
            return new CustomerRecord(customer.id, customer.getEmail(), customer.getFirstName(), customer.getLastName(), customer.getCustomerLoyaltyStatus());
        }).collect(Collectors.toList());
    }

    @Transactional
    public CustomerRecord addCustomer(CustomerRecord customerRecordToAdd) {

        Customer customer = Customer.createFromValues(customerRecordToAdd.email(), customerRecordToAdd.firstName(), customerRecordToAdd.lastName());
        customerRepository.persist(customer);
        CustomerRecord customerRecord = new CustomerRecord(customer.id, customer.getEmail(), customer.getFirstName(), customer.getLastName(), customer.getCustomerLoyaltyStatus());
        return customerRecord;
    }
}

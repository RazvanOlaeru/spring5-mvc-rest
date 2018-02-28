package guru.springfamework.services;

import guru.springfamework.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByFirstName(String firstName);

    CustomerDTO getCustomerByLastName(String lastName);

    CustomerDTO getCustomerByFirstNameAndLastName(String firstName, String lastName);
}

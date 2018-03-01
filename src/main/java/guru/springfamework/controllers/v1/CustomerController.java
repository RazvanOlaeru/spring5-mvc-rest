package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<CustomerListDTO> getAllCustomers() {
        return new ResponseEntity<CustomerListDTO>(
                new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK
        );
    }

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerById(id), HttpStatus.OK
        );
    }

    @GetMapping(value = {"", "/"}, params = "firstName")
    public ResponseEntity<CustomerDTO> getCustomerByFirstName(@RequestParam(name = "firstName") String firstName) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerByFirstName(firstName), HttpStatus.OK
        );
    }

    @GetMapping(value = {"", "/"}, params = "lastName")
    public ResponseEntity<CustomerDTO> getCustomerByLastName(@RequestParam(name = "lastName") String lastName) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerByLastName(lastName), HttpStatus.OK
        );
    }

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<CustomerDTO> getCustomerByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerByFirstNameAndLastName(firstName, lastName), HttpStatus.OK
        );
    }
}

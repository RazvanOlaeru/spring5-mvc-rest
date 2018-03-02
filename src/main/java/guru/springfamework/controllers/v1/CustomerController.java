package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping({"", "/"})
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(
                customerService.createNewCustomer(customerDTO), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id,@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(
                customerService.saveCustomerByDTO(id, customerDTO), HttpStatus.OK
        );
    }

    @PatchMapping("/{id:[\\d]+}")
    public ResponseEntity<CustomerDTO> patchCustomer(@PathVariable Long id,@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(
                customerService.patchCustomer(id, customerDTO), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomemerById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

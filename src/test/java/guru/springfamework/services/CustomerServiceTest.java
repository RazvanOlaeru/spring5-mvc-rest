package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceTest {

    public static final Long ID = 2L;
    public static final String FIRST_NAME = "Natasha";
    public static final String LAST_NAME = "Romanoff";

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE ,customerRepository);
    }

    @Test
    public void getAllCustomers() {
        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDTOS.size());
    }

    @Test
    public void getCustomerByFirstName() {
        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        //when
        Mockito.when(customerRepository.findByFirstName(FIRST_NAME)).thenReturn(customer);
        CustomerDTO customerDTO = customerService.getCustomerByFirstName(FIRST_NAME);

        //then
        assertEquals(ID, customerDTO.getId());
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
    }

    @Test
    public void getCustomerByLastName() {
        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        //when
        Mockito.when(customerRepository.findByLastName(LAST_NAME)).thenReturn(customer);
        CustomerDTO customerDTO = customerService.getCustomerByLastName(LAST_NAME);

        //then
        assertEquals(ID, customerDTO.getId());
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
    }

    @Test
    public void getCustomerByFirstNameAndLastName() {
        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        //when
        Mockito.when(customerRepository.findByFirstNameAndLastName(FIRST_NAME, LAST_NAME)).thenReturn(customer);
        CustomerDTO customerDTO = customerService.getCustomerByFirstNameAndLastName(FIRST_NAME, LAST_NAME);

        //then
        assertEquals(ID, customerDTO.getId());
        assertEquals(FIRST_NAME, customerDTO.getFirstName());
        assertEquals(LAST_NAME, customerDTO.getLastName());
    }

    @Test
    public void createNewCustomer() {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(FIRST_NAME);
        customerDTO.setLastName(LAST_NAME);

        Customer savedCustomer = new Customer();
        savedCustomer.setId(ID);
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());

        //when
        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(savedCustomer);
        CustomerDTO savedCustomerDTO = customerService.createNewCustomer(customerDTO);

        //then
        assertEquals(ID, savedCustomerDTO.getId());
        assertEquals(FIRST_NAME, savedCustomerDTO.getFirstName());
        assertEquals(LAST_NAME, savedCustomerDTO.getLastName());
        assertEquals("/api/v1/customers/" + ID, savedCustomerDTO.getCustomerUrl() );
    }
}
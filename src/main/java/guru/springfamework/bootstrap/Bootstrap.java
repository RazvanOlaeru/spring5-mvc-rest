package guru.springfamework.bootstrap;

import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;

@Component
public class Bootstrap implements CommandLineRunner {

    CategoryRepository categoryRepository;
    CustomerRepository customerRepository;

    @Autowired
    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        Category test = new Category();
        test.setName("Johnny Cage");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        categoryRepository.save(test);

        System.out.println("Data Loaded for Categories - " + categoryRepository.count());

        initCustomers();
    }

    private void initCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("Brodie");
        customer.setLastName("Pierce");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Ashanti");
        customer.setLastName("West");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Alessandra");
        customer.setLastName("Hurst");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Esperanza");
        customer.setLastName("Bridges");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Jackson");
        customer.setLastName("Duffy");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Isabelle");
        customer.setLastName("Fleming");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Christopher");
        customer.setLastName("Shelton");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Peter");
        customer.setLastName("Parker");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Clark");
        customer.setLastName("Kent");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Bruce");
        customer.setLastName("Wayne");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Diana");
        customer.setLastName("Prince");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Steve");
        customer.setLastName("Trevor");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Steve");
        customer.setLastName("Rogers");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Tony");
        customer.setLastName("Stark");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Bruce");
        customer.setLastName("Banner");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Wanda");
        customer.setLastName("Maximoff");
        customerRepository.save(customer);
        customer = new Customer();
        customer.setFirstName("Daniel");
        customer.setLastName("Rand");
        customerRepository.save(customer);

        System.out.println("Data Loaded for Customers - " + customerRepository.count());
    }

}

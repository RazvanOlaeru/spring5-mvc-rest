package guru.springfamework.repositories;

import guru.springfamework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByFirstName(String firstName);
    public Customer findByLastName(String lastName);
    public Customer findByFirstNameAndLastName(String firstName, String lastName);

}

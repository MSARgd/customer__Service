package ma.enset.CustomerService.repository;
import ma.enset.CustomerService.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface Customerrepository  extends JpaRepository<Customer,Long> {
}

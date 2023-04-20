package ma.enset.CustomerService;

import ma.enset.CustomerService.entity.Customer;
import ma.enset.CustomerService.repository.Customerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.UUID;
@SpringBootApplication
public class CustomerServiceApplication  implements CommandLineRunner {
	@Autowired
	private Customerrepository customerrepository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		for(int i=0;i<10;i++){
			customerrepository.save(Customer.builder()
							.id((long) i)
							.name(UUID.randomUUID().toString().substring(1,10))
							.email(UUID.randomUUID().toString().substring(1,10))
							.build());
		}
		/**================Test methods=====================================**/
	}
}
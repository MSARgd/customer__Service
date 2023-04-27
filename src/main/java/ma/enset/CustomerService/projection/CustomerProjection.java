package ma.enset.CustomerService.projection;
import ma.enset.CustomerService.entity.Customer;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "fullCustomer",types = Customer.class)
public interface CustomerProjection  extends Projection {
    public Long getId();
    public String getName();
    public String getEmail();
}
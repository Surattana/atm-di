package atmwitJDBC;

import java.util.List;

public interface CustomerInfoAccessObject {
    void save(Customer customer);
    void update(int id, Customer customer);
    void deleteById(int id);
    Customer findById(int id);

    List<Customer> findAll();
}

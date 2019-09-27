package atmwitJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomersInfoAccessImprement implements CustomerInfoAccessObject{

    private JdbcTemplate jdbcTemplate;
    public CustomersInfoAccessImprement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Customer customer) {

    }

    public void update(int id, Customer customer) {

    }

    public void deleteById(int id) {

    }

    public Customer findById(int id) {
        return null;
    }

    public List<Customer> findAll() {
        String query = "SELECT * FROM customers";
        List<Customer> customers = jdbcTemplate.query(query, new CustomerRowMapper());
        return customers;
    }
    public class CustomerRowMapper implements RowMapper {
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer(resultSet.getInt("number"),
                    resultSet.getInt("pin"),
                    resultSet.getInt("currentBalance"));
            return customer;
        }
    }
}

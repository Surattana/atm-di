package atmwitJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFromJDBC implements ReadDataSource {
    public Map<Integer, Customer> readCustomers() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-database.xml");
        CustomersInfoAccessImprement customersInfo = context.getBean("customerInfoAccessObjectImp", CustomersInfoAccessImprement.class);


        Map<Integer, Customer> mapCustomer = new HashMap<Integer, Customer>();
        List<Customer> customers = customersInfo.findAll();
        for (Customer customer : customers) {
            mapCustomer.put(customer.getCustomerNumber(), customer);
        }
        return mapCustomer;
    }
}

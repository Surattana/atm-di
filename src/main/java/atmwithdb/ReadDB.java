package atmwithdb;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ReadDB implements ReadData {
    public Map<Integer, Customer> readCustomers() throws IOException {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

        try {

            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:customers.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {


                String query = "Select * from customers";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int number = resultSet.getInt(1);
                    int pin = resultSet.getInt(2);
                    double currentBalance = resultSet.getDouble(3);
                    Customer c = new Customer(number, pin, currentBalance);
                    customers.put(c.getCustomerNumber(), c);

                }

                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customers;

    }

}

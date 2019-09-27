package atmwitJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-database.xml");
        ATMSimulator atmSimulator = context.getBean("atmwitJDBC.ATMSimulator", ATMSimulator.class);

        atmSimulator.run();
        //
//        DataSource dataSource = new DataSource("customers.txt");
//        atmwitJDBC.Bank bank = new atmwitJDBC.Bank(dataSource);
//        atmwitJDBC.ATM atm = new atmwitJDBC.ATM(bank);
//        atmwitJDBC.ATMSimulator atmSimulator = new atmwitJDBC.ATMSimulator(atm);
         //atmSimulator.run();
    }
}

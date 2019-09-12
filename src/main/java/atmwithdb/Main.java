package atmwithdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("dbconfig.xml");
        ATMSimulator atmSimulator = context.getBean("atmsimulator", ATMSimulator.class);
        atmSimulator.run();
    }
}

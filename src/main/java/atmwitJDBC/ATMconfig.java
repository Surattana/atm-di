package atmwitJDBC;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMconfig {
    String name;
    @Bean
    public Account account() {
        return new Account();
    }
    @Bean
    public ATM atm() {
        return new ATM(bank());
    }
    @Bean
    public Bank bank() {
        return new Bank(readDatabase());
    }
    @Bean
    public ReadDataSource readFromFile() {
        return new ReadFromFile("customers.txt");
    }
    @Bean
    public ReadDataSource readDatabase() {
        return new ReadDatabase();
    }

    @Bean
    public ATMSimulator atmSimulator() {
        return new ATMSimulator(atm());
    }




}

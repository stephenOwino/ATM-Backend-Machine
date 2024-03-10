package stephenowino.com.ATMBackendMachine.Model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private double balance;

    public UserAccount(Long accountId) {
        this.accountId = accountId;
    }

    //method to deposit money
    public void deposit(double amount, Long accountId) {
        //Add the deposit amount to the balance
        this.balance += amount;
    }

    public void withdraw(double amount, Long accountId) {
        //withdraw amount from the balance
        this.balance -= amount;
    }
    public double checkBalance(Long accountId){
        return this.balance;
    }
}
 
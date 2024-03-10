package stephenowino.com.ATMBackendMachine.Service;

import org.springframework.stereotype.Service;
import stephenowino.com.ATMBackendMachine.Model.UserAccount;

@Service
public class UserService{

    private final UserAccount userAccount;

    public UserService(UserAccount userAccount) {
        this.userAccount = userAccount;

    }
        //method to withdraw money from the users account
        public String withdraw(double amount ,Long accountId){
        try {
            //validate the withdrawal amount
            if (amount <= 0){
                return "Invalid Withdrawal Amount";
            }

            //validate sufficient balance
            if (userAccount.checkBalance(accountId) < amount){
                return "Only " + userAccount.checkBalance(accountId) + "$ available. Withdrawal not processed.";

            }
            //perform withdrawal and update balance
            userAccount.withdraw(amount,accountId);
            return "Withdrawal successful.Remaining balance " + userAccount.checkBalance(accountId) + "$";

        }catch (Exception e){
            //log the exception for troubleshooting
            e.printStackTrace();
            return "Error during withdrawal.please contact customer support.";


        }

    }
    //method to deposit money
    public String deposit(double amount ,Long accountId){
        try {
            //validate deposit amount
            if (amount <= 0){
                return "Invalid deposit amount.";
            }
            //perform deposit and update balance
            userAccount.deposit(amount,accountId);
            return "Deposit of " + amount + "$ made. New balance: "+ userAccount.checkBalance(accountId) + "$";

        }catch (Exception e){
            //log the exception for troubleshooting
            //notify the administrator
            e.printStackTrace();
            return "Error during deposit.Please contact customer support ";

        }
    }
    //check balance
    public String checkBalance(Long accountId){
        try {
            return "Your current balance is: " + userAccount.checkBalance(accountId) + "$";

        }catch (Exception e){
            //for troubleshooting
            //log detailed information of send an alert to notify administrator
            e.printStackTrace();
            return "Error while checking balance.Please contact customer support.";
        }
    }
}
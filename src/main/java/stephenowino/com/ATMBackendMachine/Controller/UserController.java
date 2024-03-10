package stephenowino.com.ATMBackendMachine.Controller;

import org.springframework.web.bind.annotation.*;
import stephenowino.com.ATMBackendMachine.Service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/atm")
public class UserController{

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/deposit")
    public String deposit(@RequestBody Map<String , Object> requestBody){
        Object amountObject = requestBody.get("amount");
        double amount = amountObject instanceof Number? ((Number) amountObject).doubleValue(): 0.0;
        Long accountId = ((Number) requestBody.get("accountId")).longValue();
        return userService.deposit(amount,accountId);
    }
    @PostMapping("/withdraw")
    public String withdraw(@RequestBody Map<String ,Object> requestBody){
        Object amountObject = requestBody.get("amount");
        double amount = amountObject instanceof Number?((Number) amountObject).doubleValue() : 0.0;
        Long accountId = ((Number) requestBody.get("accountId")).longValue();
        return userService.withdraw(amount,accountId);
    }

    //endpoint for checking balance
    @GetMapping("/balance")
    public String checkBalance(@RequestParam Long accountId){
        return userService.checkBalance(accountId);
    }

}
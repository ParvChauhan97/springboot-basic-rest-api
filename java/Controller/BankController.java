package org.example.springsyatem.springbank.Controller;

import org.example.springsyatem.springbank.Service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController 
@RequestMapping("/account")
public class BankController {
 
  private final BankService bankservice;
    public BankController(BankService bankservice) {
        this.bankservice = bankservice;
    }
  
  @PostMapping("/createuser")
    public ResponseEntity<?> createAccount(@RequestBody long accountNumber,
                                           @RequestBody String name) {
        boolean check = bankservice.createAccount(accountNumber, name);
        if (check) return ResponseEntity.status(HttpStatus.CREATED).body("Success");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Enter Right Information");
    }
  
@PutMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestParam long accountNumber,
                                     @RequestParam double amount) {
        boolean check = bankservice.deposit(accountNumber, amount);
        if (check) return ResponseEntity.ok("Deposit Successful");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Enter Right Information");
    }

@PutMapping("/withdraw")  
public ResponseEntity<?> withdraw(@RequestParam long accountNumber,  
                                            @RequestParam double amount) {  
    boolean check = bankservice.withdraw(accountNumber, amount);  
    if (check) return ResponseEntity.ok("Withdraw Successful");  
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Enter Right Information");  
}  

  @PutMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestParam long sender,
                                      @RequestParam long receiver,
                                      @RequestParam double amount) {
        boolean check = bankservice.transfer(sender, receiver, amount);
        if(check) return ResponseEntity.ok( "Transfer Successful");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter Right Information");
    }

  @GetMapping("/display")
    public ResponseEntity<?> display(@RequestParam long accountNumber) {
        return ResponseEntity.ok(bankservice.display(accountNumber));
    }

  @GetMapping("/displayall")
    public ResponseEntity<?> displayAll() {
        return ResponseEntity.ok(bankservice.displayall());
    }

}

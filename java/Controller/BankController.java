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
}

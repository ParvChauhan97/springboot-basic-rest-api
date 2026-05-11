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
}

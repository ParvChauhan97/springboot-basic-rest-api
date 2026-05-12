package org.example.springsyatem.springbank.Service;
import org.example.springsyatem.springbank.Model.BankAccount;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {
    private HashMap<Long, BankAccount> map = new HashMap<>();
  
}

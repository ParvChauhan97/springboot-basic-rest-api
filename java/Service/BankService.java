package org.example.springsyatem.springbank.Service;
import org.example.springsyatem.springbank.Model.BankAccount;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {
    private HashMap<Long, BankAccount> map = new HashMap<>();

     public boolean createAccount(long accountNumber, String name) {
        if(!map.containsKey(accountNumber)) {
            map.put(accountNumber, new BankAccount(accountNumber, name, 0.0));
            return true;
        }
        return false;
    }
    
}

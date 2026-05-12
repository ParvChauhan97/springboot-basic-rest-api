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

    public boolean deposit(long accountNumber, double amount) {
        if (map.containsKey(accountNumber)) {
            BankAccount acc = map.get(accountNumber);
                acc.deposit(amount);
                return true;
        } return false;
    }

    public boolean withdraw(long accountNumber, double amount) {
        if (map.containsKey(accountNumber)) {
            BankAccount acc = map.get(accountNumber);
            if(amount <= acc.getBalance()) {
                acc.withdraw(amount);
                return true;
            }
        } return false;
    }

    public boolean transfer(long sender, long receiver, double amount) {
        if(map.containsKey(sender) && map.containsKey(receiver)) {
                BankAccount s = map.get(sender);
                BankAccount r = map.get(receiver);
                if (amount <= s.getBalance()) {
                    s.withdraw(amount);
                    r.deposit(amount);
                    return true;
                }
            }
            return false;
        }

    public String display(long accountNumber) {
        if(map.containsKey(accountNumber)) {
            BankAccount account = map.get(accountNumber);
            return account.display();
        }
        return "Enter Valid Account Number";
    }

    public Map<Long, BankAccount> displayall(){
        return map;
    }
    
}

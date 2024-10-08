package Controller;

import Entity.Account;
import Service.AccountService;

import java.util.List;

public class AccountController {

    private AccountService as;
    private Account account;

    public AccountController(AccountService as) {
        this.as = as;
    }

    public Account getAccById(int id) {
        Account found = as.getAccById(id);
        if (found == null) {
            return null;
        }else {
            return found;
        }
    }

    public List<Account> getAccByCusName(String name) {
        List<Account> found = as.getAccByCusName(name);
        if (found != null) {
            return found;
        }else {
            return null;
        }
    }


}

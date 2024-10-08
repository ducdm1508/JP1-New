package Controller;

import Entity.Account;
import Service.AccountService;

import java.util.List;

public class AccountController {
    private AccountService as;

    public AccountController(AccountService as) {
        this.as = as;
    }

    public List<Account> update(Account account) {
        return as.update(account);
    }

    public List<Account> sort() {
        return as.sort();
    }

    public Account getById(int id) {
        Account findId = as.getById(id);
        if (findId != null) {
            return findId;
        } else {
            return null;
        }
    }

    public List<Account> getByName(String name) {
        List<Account> findName = as.getByName(name);
        if (findName != null) {
            return findName;
        } else {
            return null;
        }
    }
}

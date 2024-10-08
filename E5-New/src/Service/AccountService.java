package Service;

import Entity.Account;
import Global.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {

    List<Account> accounts;
    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }


    public Account getAccById(int id){

        Optional<Account> findAcc = accounts.stream()
                        .filter(acc -> acc.getId() == id)
                        .findFirst();
        if (findAcc.isPresent()) {
            return findAcc.get();
        }else {
            return null;
        }

    }

    public List<Account> getAccByCusName(String name){

        List<Account> findAcc = accounts.stream()
                .filter(acc -> Global.ignoreCase(acc.getCusName(), name))
                .toList();

        if (findAcc.size() > 0 ) {
            return findAcc;
        }else {
            return null;
        }
    }
}

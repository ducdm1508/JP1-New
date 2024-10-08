package Service;

import Entity.Account;
import Entity.Customer;
import Global.Global;
import IGeneric.IGeneral;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountService implements IGeneral<Account> {

    private List<Account> accounts;
    public AccountService(List<Account> accounts){
        this.accounts = accounts;
    }

    @Override
    public List<Account> update(Account account) {
        accounts.removeIf(cus-> cus.getId() == account.getId());
        accounts.add(account);
        return new ArrayList<>(accounts);
    }

    @Override
    public List<Account> sort() {
        return accounts.stream()
                .sorted(Comparator.comparing(Account::getBlance))
                .toList();
    }

    @Override
    public Account getById(int id) {
        Optional<Account> findAcc = accounts.stream()
                .filter(acc -> acc.getId() == id)
                .findFirst();
        if(findAcc.isPresent()){
            return findAcc.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Account> getByName(String keyword) {
        List<Account> findAcc = accounts.stream()
                .filter(acc -> Global.ignoreCase(acc.getCusName(), keyword))
                .toList();
        if (findAcc.size()>0){
            return findAcc;
        }else {
            return null;
        }
    }
}

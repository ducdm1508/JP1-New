package Service;

import Entity.Account;
import Entity.Gender;
import Entity.Invoice;
import Global.Global;
import IGeneric.IGeneral;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InvoiceService implements IGeneral<Invoice> {

    private List<Invoice> invoices;

    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public List<Invoice> update(Invoice invoice) {
        invoices.removeIf(inv -> inv.getId() == invoice.getId());
        invoices.add(invoice);
        return new ArrayList<>(invoices);
    }

    @Override
    public List<Invoice> sort() {
        return invoices.stream()
                .sorted(Comparator.comparing(Invoice::getAmount))
                .toList();
    }

    @Override
    public Invoice getById(int id) {
        Optional<Invoice> findInv = invoices.stream()
                .filter(inv -> inv.getId() == id)
                .findFirst();
        if(findInv.isPresent()){
            return findInv.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Invoice> getByName(String keyword) {
        List<Invoice> findInv = invoices.stream()
                .filter(inv -> Global.ignoreCase(inv.getCusName(), keyword))
                .toList();
        if(findInv.size()>0){
            return findInv;
        }else {
            return null;
        }
    }
    public List<Invoice> applyDiscountForFemaleAugustInvoices() {
        List<Invoice> discountedInvoices = invoices.stream()
                .filter(inv -> inv.getCustomer().getGender() == Gender.F)
                .filter(inv -> inv.getDatetime().isBefore(LocalDate.now().minusMonths(8)))
                .toList();

        discountedInvoices.forEach(inv -> {
            double discount = inv.getCustomer().getDiscount() + 10;
            inv.setAmount(inv.getAmount() * (1 - discount/100));
        });
        if (discountedInvoices.size() > 0) {
            return discountedInvoices;
        }else {
            return null;
        }
    }

    public List<Invoice> getCusCanNotPay(List<Account> accounts) {
        List<Invoice> cusCanNotPay = new ArrayList<>();

        accounts.forEach(account -> {
            List<Invoice> unpayableInvoices = invoices.stream()
                    .filter(inv -> inv.getCustomer().equals(account.getCustomer()))
                    .filter(invoice -> account.getBlance() < invoice.getAmountAfterDiscount())
                    .toList();
            cusCanNotPay.addAll(unpayableInvoices);
        });

        if (cusCanNotPay.size() > 0) {
            return cusCanNotPay;
        } else {
            return null;
        }
    }

    public List<Invoice> getCusCanPay(List<Account> accounts) {
        List<Invoice> cusCanNotPay = new ArrayList<>();

        accounts.forEach(account -> {
            List<Invoice> unpayableInvoices = invoices.stream()
                    .filter(inv -> inv.getCustomer().equals(account.getCustomer()))
                    .filter(invoice -> account.getBlance() >= invoice.getAmountAfterDiscount())
                    .toList();
            cusCanNotPay.addAll(unpayableInvoices);
        });

        if (cusCanNotPay.size() > 0) {
            return cusCanNotPay;
        }else {
            return null;
        }
    }
}

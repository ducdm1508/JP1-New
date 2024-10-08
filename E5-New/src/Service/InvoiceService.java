package Service;

import Entity.Account;
import Entity.Gender;
import Entity.Invoice;
import Global.Global;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceService {

    private List<Invoice> invoices;

    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Invoice getInvoiceId(int id) {
        Optional<Invoice> findInv =
                invoices.stream()
                        .filter(i -> i.getId() == id)
                        .findFirst();
        return findInv.isPresent() ? findInv.get() : null;
    }

    public List<Invoice> getInvoiceByName(String name) {
        List<Invoice> findInv = invoices.stream()
                .filter(inv -> Global.ignoreCase(inv.getCusName(), name))
                .toList();
        return findInv.size() > 0 ? findInv : null;
    }

    public List<Invoice> applyDiscountForFemaleAugustInvoices() {
        List<Invoice> discountedInvoices = invoices.stream()
                .filter(inv -> inv.getCustomer().getGender() == Gender.F)
                .filter(inv -> inv.getDatetime().getMonthValue() == 8)
                .toList();

        discountedInvoices.forEach(inv -> {
            double discount = inv.getCustomer().getDiscount() + 10;
            inv.setAmount(inv.getAmount() * (1 - discount / 100));
        });
        return discountedInvoices.size() > 0 ? discountedInvoices : null;
    }

    public List<Invoice> getCusCanNotPay(List<Account> accounts) {
        List<Invoice> cusCanNotPay = new ArrayList<>();

        accounts.forEach(account -> {
            List<Invoice> unpayableInvoices = invoices.stream()
                    .filter(inv -> inv.getCustomer().equals(account.getCustomer()))
                    .filter(invoice -> account.getBalance() < invoice.getAmountAfterDiscount())
                    .toList();
            cusCanNotPay.addAll(unpayableInvoices);
        });

        return cusCanNotPay.size() > 0 ? cusCanNotPay : null;
    }

    public List<Invoice> getCusCanPay(List<Account> accounts) {
        List<Invoice> cusCanPay = new ArrayList<>();

        accounts.forEach(account -> {
            List<Invoice> payableInvoices = invoices.stream()
                    .filter(inv -> inv.getCustomer().equals(account.getCustomer()))
                    .filter(invoice -> account.getBalance() >= invoice.getAmountAfterDiscount())
                    .toList();
            cusCanPay.addAll(payableInvoices);
        });

        return cusCanPay.size() > 0 ? cusCanPay : null;
    }
}

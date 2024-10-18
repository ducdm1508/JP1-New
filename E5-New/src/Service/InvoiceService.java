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

            double currentDiscount = inv.getCustomer().getDiscount();
            double newDiscount = currentDiscount + 10;
            inv.getCustomer().setDiscount(newDiscount);

            double discountedAmount = inv.getAmount() * (1 - newDiscount / 100);
            inv.setAmount(discountedAmount);
        });

        return discountedInvoices.isEmpty() ? null : discountedInvoices;
    }


    public Invoice payBill(Account account) {
        Optional<Invoice> payInvoice = invoices.stream()
                .filter(inv -> inv.getCustomer().getId() == account.getCustomer().getId())
                .filter(inv -> {
                    if (inv.getCustomer().getGender() == Gender.F && inv.getDatetime().getMonthValue() == 8) {
                        double discount = inv.getCustomer().getDiscount() + 10;
                        inv.getCustomer().setDiscount(discount);
                        inv.setAmount(inv.getAmount() * (1 - discount / 100));
                    }
                    return account.getBalance() >= inv.getAmountAfterDiscount();
                })
                .findFirst();

        if (payInvoice.isPresent()) {
            double newBalance = account.getBalance() - payInvoice.get().getAmountAfterDiscount();
            account.setBalance(newBalance);
            return payInvoice.get();
        } else {
            return null;
        }
    }
}

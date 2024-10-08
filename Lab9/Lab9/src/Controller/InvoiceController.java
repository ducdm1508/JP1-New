package Controller;

import Entity.Account;
import Entity.Invoice;
import Service.InvoiceService;

import java.util.List;

public class InvoiceController {

    private InvoiceService is;

    public InvoiceController(InvoiceService is) {
        this.is = is;
    }

    public List<Invoice> update(Invoice invoice) {
        return is.update(invoice);
    }

    public List<Invoice> sort() {
        return is.sort();
    }

    public Invoice getById(int id) {
        Invoice findId = is.getById(id);
        if (findId != null) {
            return findId;
        } else {
            return null;
        }
    }

    public List<Invoice> getByName(String name) {
        List<Invoice> findName = is.getByName(name);
        if (findName != null) {
            return findName;
        } else {
            return null;
        }
    }
    public List<Invoice> applyDiscountForFemaleAugustInvoices(){
        List<Invoice> discouted = is.applyDiscountForFemaleAugustInvoices();
        if (discouted != null){
            return discouted;
        }else {
            return null;
        }
    }

    public List<Invoice> getCusCanNotPay(List<Account> accounts){
        List<Invoice> cusCanNotPay = is.getCusCanNotPay(accounts);
        if (cusCanNotPay != null){
            return cusCanNotPay;
        }else {
            return null;
        }
    }

    public List<Invoice> getCusCanPay(List<Account> accounts){
        List<Invoice> cusCanPay = is.getCusCanPay(accounts);
        if (cusCanPay != null){
            return cusCanPay;
        }else {
            return null;
        }
    }
}

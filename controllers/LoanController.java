package ledgerbanking.controllers;

import ledgerbanking.data.BankDBService;
import ledgerbanking.model.Balance;
import ledgerbanking.model.Bank;
import ledgerbanking.model.Customer;
import ledgerbanking.model.Loan;
import ledgerbanking.model.Payment;
import ledgerbanking.utils.LoanUtil;

public class LoanController {
    public void createLoan(Loan loan){
        BankDBService bankService = new BankDBService();
        bankService.storeLoan(loan);
    }

    public Loan getLoan(Bank bank, Customer customer) {
        return getLoan(bank.getBankName(), customer.getCustomerName());
    }

    public Loan getLoan(String bankName, String customerName) {
        BankDBService bankService = new BankDBService();
        return bankService.getLoan(bankName, customerName);
    }

    public void payLumpSumAmount(Payment payment){
        BankDBService bankService = new BankDBService();
        bankService.storePayment(payment);
    }

    public Balance getBalance(String bankName, String customerName, int emiCount) {
        return LoanUtil.getBalance(bankName, customerName, emiCount);
    }
    
}

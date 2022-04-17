package ledgerbanking.data;

import java.util.HashMap;

import ledgerbanking.model.Bank;
import ledgerbanking.model.Loan;
import ledgerbanking.model.Payment;

public class BankDBService {
    
    public void storeBank(Bank bank) {
        DataStore.getBankDetails().putIfAbsent(bank.getBankName(), bank);
    }

    public Bank getBank(String bankName) {
        return DataStore.getBankDetails().get(bankName);
    }

    public void storeLoan(Loan loan) {
        String bankName = loan.getBank().getBankName();
        String customerName = loan.getCustomer().getCustomerName();

        HashMap<String, HashMap<String, Loan>> loanDetails = DataStore.getLoanDetails();
        
        loanDetails.putIfAbsent(bankName, new HashMap<String, Loan>());
        loanDetails.get(bankName).put(customerName, loan);        
    }

    public Loan getLoan(String bankName, String customerName) {
        HashMap<String, Loan> cxVsLoan = DataStore.getLoanDetails().get(bankName);
        return cxVsLoan == null ?  null : cxVsLoan.get(customerName);
    }

    public void storePayment(Payment payment) {
        Loan loan = getLoan(payment.getBankName(), payment.getCustomerName());
        if(loan != null){
            loan.getEmiDetails().put(payment.getEmiNo(), payment);
        }
    }

}

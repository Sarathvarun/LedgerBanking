package ledgerbanking.utils;

import java.util.Map;
import java.util.TreeMap;

import ledgerbanking.controllers.LoanController;
import ledgerbanking.model.Balance;
import ledgerbanking.model.Loan;
import ledgerbanking.model.Payment;

public class LoanUtil {
    public static Balance getBalance(String bankName, String customerName, int emiCount) {
        
        LoanController loanController = new LoanController();
        Loan loan = loanController.getLoan(bankName, customerName);

        TreeMap<Integer, Payment> emiDetails = loan.getEmiDetails();

        long interestMoney = (long) Math.ceil(loan.getPrincipal() * loan.getNoOfYears() * (loan.getRateOfInterest() / 100));
        long totalPayment = loan.getPrincipal() + interestMoney;

        long emi = (long) Math.ceil((double)totalPayment/(loan.getNoOfYears() * 12));

        long currentPaidEMI = emi * emiCount;


        for(Map.Entry<Integer, Payment> entry : emiDetails.entrySet()) {
            if(entry.getKey() <= emiCount) {
                currentPaidEMI += entry.getValue().getLumpSumAmount();
            } else {
                break;
            }
        }

        long balancePayment = totalPayment - currentPaidEMI;
        int balEmiCount = (int)Math.ceil((double)balancePayment / emi);

        Balance balance = new Balance(bankName, customerName, currentPaidEMI, balEmiCount);
        return balance;
    }
}

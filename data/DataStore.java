package ledgerbanking.data;

import java.util.HashMap;

import ledgerbanking.model.Bank;
import ledgerbanking.model.Customer;
import ledgerbanking.model.Loan;

class DataStore {
    private static HashMap<String, Bank> bankDetails = new HashMap<>();
    private static HashMap<String, Customer> customerDetails = new HashMap<>();
    private static HashMap<String, HashMap<String, Loan>> loanDetails = new HashMap<>();

    public static HashMap<String, Bank> getBankDetails() {
        return bankDetails;
    }

    public static void setBankDetails(HashMap<String, Bank> bankDetails) {
        DataStore.bankDetails = bankDetails;
    }

    public static HashMap<String, Customer> getCustomerDetails() {
        return customerDetails;
    }

    public static void setCustomerDetails(HashMap<String, Customer> customerDetails) {
        DataStore.customerDetails = customerDetails;
    }

    public static HashMap<String, HashMap<String, Loan>> getLoanDetails() {
        return loanDetails;
    }

    public static void setLoanDetails(HashMap<String, HashMap<String, Loan>> loanDetails) {
        DataStore.loanDetails = loanDetails;
    }

    
}

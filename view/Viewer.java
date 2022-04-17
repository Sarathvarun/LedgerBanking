package ledgerbanking.view;

import ledgerbanking.model.Balance;

public class Viewer {
    public static void print(String output){
        System.out.println(output);
    }
    
    public static void printBalance(Balance balance) {
        System.out.println(balance.getBankName() + " " + balance.getCustomerName() + " " + balance.getPrincipalPaid() + " " + balance.getPedingEMICount());
    }
}

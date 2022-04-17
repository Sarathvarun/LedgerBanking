package ledgerbanking.controllers;

import ledgerbanking.data.BankDBService;
import ledgerbanking.model.Bank;

public class BankController {
        
    public void createBank(Bank bank){
        BankDBService bankService = new BankDBService();
        bankService.storeBank(bank);
    }

    public Bank getBank(String bankName) {
        BankDBService bankService = new BankDBService();
        return bankService.getBank(bankName);
    }
    
}

package ledgerbanking.model.builder;

import ledgerbanking.controllers.BankController;
import ledgerbanking.controllers.CustomerController;
import ledgerbanking.controllers.LoanController;
import ledgerbanking.errorhandling.ErrorHandler;
import ledgerbanking.model.Bank;
import ledgerbanking.model.Customer;
import ledgerbanking.model.Loan;

public class LoanBuilder {
    
    /**
     * Format - LOAN 
     *          BANK_NAME 
     *          BORROWER_NAME 
     *          PRINCIPAL 
     *          NO_OF_YEARS 
     *          RATE_OF_INTEREST
     * @param loanCommand
     * @return
     */
    public Loan buildLoan(String loanCommand) throws Exception {
        
        validate(loanCommand);
        
        String[] loanCommandSplits = loanCommand.split(" ");

        String bankName = loanCommandSplits[1];
        String customerName = loanCommandSplits[2];
        long principal = Long.valueOf(loanCommandSplits[3]);
        int tenure = Integer.valueOf(loanCommandSplits[4]);
        float interest = Float.valueOf(loanCommandSplits[5]);

        BankController bankController = new BankController();
        Bank bank = bankController.getBank(bankName);
        if(bank == null) {
            bank = new Bank(bankName);
            bankController.createBank(bank);
        }

        CustomerController customerController = new CustomerController();
        Customer customer = customerController.getCustomer(customerName);
        if(customer == null) {
            customer = new Customer(customerName);
            customerController.createCustomer(customer);
        }

        LoanController loanController = new LoanController();
        Loan loan = loanController.getLoan(bank, customer);
        if(loan == null) {
            loan = new Loan(bank, customer, principal, tenure, interest);
            loanController.createLoan(loan);
        }

        return loan;
    }

    private static void validate(String loanCommand) throws Exception {
        String[] loanCommandSplits = loanCommand.split(" ");
        //Command validation
        if(loanCommandSplits.length != 6) {
            ErrorHandler.throwError("Invalid details to create loan");
        }

        String command = loanCommandSplits[0];
        //Command validation
        if(!"LOAN".equals(command)) {
            ErrorHandler.throwError("Invalid Command");
        }

        //Principal validation
        try{
            Long.valueOf(loanCommandSplits[3]);
        } catch(Exception e){
            ErrorHandler.throwError("Invalid Principal amount");
        }

        //Loan tenure validation
        try{
            Integer.valueOf(loanCommandSplits[4]);
        } catch(Exception e){
            ErrorHandler.throwError("Invalid Loan tenure");
        }

        //Interest validation
        try{
            Float.valueOf(loanCommandSplits[5]);
        } catch(Exception e){
            ErrorHandler.throwError("Invalid rate of interest");
        }

    }
}

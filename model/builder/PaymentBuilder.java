package ledgerbanking.model.builder;

import ledgerbanking.controllers.LoanController;
import ledgerbanking.errorhandling.ErrorHandler;
import ledgerbanking.model.Payment;

/**Format - PAYMENT 
 *          BANK_NAME 
 *          BORROWER_NAME 
 *          LUMP_SUM_AMOUNT 
 *          EMI_NO

 * 
 */
public class PaymentBuilder {
    public Payment buildPayment(String payCommand) throws Exception {

        validate(payCommand);

        String[] payCommandSplits = payCommand.split(" ");

        String bankName = payCommandSplits[1];
        String customerName = payCommandSplits[2];
        long lumpSumAmount = Long.valueOf(payCommandSplits[3]);
        int emiNo = Integer.valueOf(payCommandSplits[4]);

        Payment payment = new Payment(bankName, customerName, lumpSumAmount, emiNo);
        
        return payment;
    }

    private static void validate(String payCommand) throws Exception {
        String[] payCommandSplits = payCommand.split(" ");
        //Command validation
        if(payCommandSplits.length != 5) {
            ErrorHandler.throwError("Invalid details to create payment");
        }

        String command = payCommandSplits[0];
        //Command validation
        if(!"PAYMENT".equals(command)) {
            ErrorHandler.throwError("Invalid Command");
        }

        //Bank validation
        try{
            String.valueOf(payCommandSplits[1]);
        } catch(Exception e){
            ErrorHandler.throwError("Invalid Bank");
        }

        //Customer validation
        try{
            String.valueOf(payCommandSplits[2]);
        } catch(Exception e){
            ErrorHandler.throwError("Invalid Customer");
        }

        //lumpSumAmount tenure validation
        try{
            Long.valueOf(payCommandSplits[3]);
        } catch(Exception e){
            ErrorHandler.throwError("Invalid lumpSumAmount");
        }

        //EMI no validation
        try{
            Integer.valueOf(payCommandSplits[4]);
        } catch(Exception e){
            ErrorHandler.throwError("Invalid EMI No");
        }

    }
}

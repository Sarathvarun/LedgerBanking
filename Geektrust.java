package ledgerbanking;
import java.io.File;
import java.util.Scanner;

import ledgerbanking.model.Payment;
import ledgerbanking.model.Balance;
import ledgerbanking.model.Loan;
import ledgerbanking.controllers.LoanController;
import ledgerbanking.model.builder.LoanBuilder;
import ledgerbanking.model.builder.PaymentBuilder;
import ledgerbanking.view.Viewer;

public class Geektrust {

	public static void main(String[] args)  {
		Scanner scanner = null;
        try
        {
            String filePath = args[0];
            //String filePath = "/Users/sarath-4141/Documents/VARUN/Java/Navi/ledgerbanking/Input.txt";
            File file = new File(filePath);
            scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                String input = scanner.nextLine();

                if(input.startsWith("LOAN")){
                    LoanBuilder loanBuilder = new LoanBuilder();
                    Loan loan = loanBuilder.buildLoan(input);

                    LoanController loanController = new LoanController();
                    loanController.createLoan(loan);

                } else if(input.startsWith("BALANCE")) {
                    String[] balArr = input.split(" ");
                    LoanController loanController = new LoanController();
                    Balance balance = loanController.getBalance(balArr[1], balArr[2], Integer.valueOf(balArr[3])); 
                    
                    Viewer.printBalance(balance);

                } else if(input.startsWith("PAYMENT")){
                    PaymentBuilder paymentBuilder = new PaymentBuilder();
                    Payment payment = paymentBuilder.buildPayment(input);
                    
                    LoanController loanController = new LoanController();
                    loanController.payLumpSumAmount(payment);
                } 
            }
    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(scanner != null) {
                scanner.close();
            }
        }
	}
}
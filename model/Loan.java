package ledgerbanking.model;

import java.util.TreeMap;

public class Loan 
{
    private Bank bank;
    private Customer customer;
    private long principal; 
    private int noOfYears; 
    private float rateOfInterest;

    private TreeMap<Integer, Payment> emiDetails = new TreeMap<Integer, Payment>();

    private Loan(){}
    
    public Loan(Bank bank, Customer customer, long principal, int noOfYears, float rate_of_interest) {
        this.bank = bank;
        this.customer = customer;
        this.principal = principal;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rate_of_interest;
    }

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public long getPrincipal() {
        return principal;
    }
    public void setPrincipal(long principal) {
        this.principal = principal;
    }
    public int getNoOfYears() {
        return noOfYears;
    }
    public void setNoOfYears(int no_of_years) {
        this.noOfYears = no_of_years;
    }
    public float getRateOfInterest() {
        return rateOfInterest;
    }
    public void setRateOfInterest(float rate_of_interest) {
        this.rateOfInterest = rate_of_interest;
    }

    public TreeMap<Integer, Payment> getEmiDetails() {
        return emiDetails;
    }
    public void setEmiDetails(Payment payment) {
        this.emiDetails = emiDetails;
    }
    
    
}

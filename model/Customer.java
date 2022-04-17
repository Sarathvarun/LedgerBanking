package ledgerbanking.model;
public class Customer 
{
    private String customerName;

    private Customer(){}

    public Customer(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String name) {
        this.customerName = customerName;
    }

    
}

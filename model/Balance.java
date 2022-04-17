package ledgerbanking.model;

public class Balance {
    private String bankName;
    private String customerName;
    private Long principalPaid;
    private int pedingEMICount;

    private Balance() {}

    public Balance(String bankName, String customerName, Long principalPaid, int pedingEMICount) {
        this.bankName = bankName;
        this.customerName = customerName;
        this.principalPaid = principalPaid;
        this.pedingEMICount = pedingEMICount;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Long getPrincipalPaid() {
        return principalPaid;
    }
    public void setPrincipalPaid(Long principalPaid) {
        this.principalPaid = principalPaid;
    }
    public int getPedingEMICount() {
        return pedingEMICount;
    }
    public void setPedingEMICount(int pedingEMICount) {
        this.pedingEMICount = pedingEMICount;
    }

    
}

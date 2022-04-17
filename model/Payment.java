package ledgerbanking.model;

public class Payment {
    private String bankName;
    private String customerName;
    private long lumpSumAmount; 
    private int emiNo;

    private Payment(){}
    
    public Payment(String bankName, String customerName, long lumpSumAmount, int emiNo) {
        this.bankName = bankName;
        this.customerName = customerName;
        this.lumpSumAmount = lumpSumAmount;
        this.emiNo = emiNo;
    }
    
    public String getBankName() {
        return bankName;
    }
    public void setBankNae(String bankName) {
        this.bankName = bankName;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public long getLumpSumAmount() {
        return lumpSumAmount;
    }
    public void setLumpSumAmount(long lumpSumAmount) {
        this.lumpSumAmount = lumpSumAmount;
    }
    public int getEmiNo() {
        return emiNo;
    }
    public void setEmiNo(int emiNo) {
        this.emiNo = emiNo;
    }
    

    
}
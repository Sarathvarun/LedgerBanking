package ledgerbanking.model;
public class Bank 
{
    private String bankName;

    private Bank() {}

    public Bank(String name) {
        this.bankName = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }  

}

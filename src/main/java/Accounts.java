public abstract class Accounts implements AccountOperations {

    private String accNo;
    private String accName;
    private String accType;
    protected double accBalance;
    private boolean accIsActive;

    public Accounts(String accNo, String accName, String accType, double accBalance) {
        this.accNo = accNo;
        this.accName = accName;
        this.accType = accType;
        this.accBalance = accBalance;
        this.accIsActive = true;
    }

    public String getAccNo() {
        return accNo;
    }

    public String getAccType() {
        return accType;
    }

    @Override
    public double checkBalance() {
        return accBalance;
    }

    public abstract void deposit(double amount) throws InvalidAmountException;

    public abstract void withdraw(double amount) throws InvalidAmountException;
}

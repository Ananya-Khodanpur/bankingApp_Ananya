public abstract class Accounts implements AccountOperations {

    private int accNo;
    private String accName;
    private String accType;
    protected double accBalance;
    private boolean accIsActive;

    public Accounts(int accNo, String accName, String accType, double accBalance, boolean accIsActive) {
        this.accNo = accNo;
        this.accName = accName;
        this.accType = accType;
        this.accBalance = accBalance;
        this.accIsActive = accIsActive;
    }

    // Getters and setters
    public int getAccNo() {
        return accNo;
    }

    public String getAccName() {
        return accName;
    }

    public String getAccType() {
        return accType;
    }

    public boolean isAccIsActive() {
        return accIsActive;
    }

    @Override
    public double checkBalance() {
        return accBalance;
    }


    public abstract void deposit(double amount) throws InvalidAmountException;

    public abstract void withdraw(double amount) throws InvalidAmountException;
}

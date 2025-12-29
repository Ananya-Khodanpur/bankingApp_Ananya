public class CurrentAccount extends Accounts {

    private boolean odEnabled;

    public CurrentAccount(String accNo, String name, double balance, boolean odEnabled) {
        super(accNo, name, "CURRENT", balance);
        this.odEnabled = odEnabled;
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Deposit must be positive");
        accBalance += amount;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        if (amount > 25000)
            throw new InvalidAmountException("Current withdrawal limit is 25000");
        if (amount > accBalance && !odEnabled)
            throw new InvalidAmountException("Overdraft not enabled");
        accBalance -= amount;
    }
}

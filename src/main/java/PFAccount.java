public class PFAccount extends Accounts {

    public PFAccount(String accNo, String name, double balance) {
        super(accNo, name, "PF", balance);
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Deposit must be positive");
        accBalance += amount;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        if (amount > accBalance * 0.7)
            throw new InvalidAmountException("PF allows max 70% withdrawal");
        accBalance -= amount;
    }
}

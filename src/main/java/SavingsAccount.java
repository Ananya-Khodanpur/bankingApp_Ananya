public class SavingsAccount extends Accounts {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, "SAVINGS", balance,true);
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Deposit must be positive");
        accBalance += amount;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        if (amount > 5000)
            throw new InvalidAmountException("Savings withdrawal limit is 5000");
        if (amount > accBalance)
            throw new InvalidAmountException("Insufficient balance");
        accBalance -= amount;
    }
}

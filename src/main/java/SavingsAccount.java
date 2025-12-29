public class SavingsAccount extends Accounts {

    public SavingsAccount(int accNo, String accName, double balance) {
        super(accNo, accName, "SAVINGS", balance, true);
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero");
        }
        accBalance += amount;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid withdrawal amount");
        }
        if (amount > 5000) {
            throw new InvalidAmountException("Savings account allows max 5000 per transaction");
        }
        if (amount > accBalance) {
            throw new InvalidAmountException("Insufficient balance");
        }
        accBalance -= amount;
    }
}


public class CurrentAccount extends Accounts {

    private boolean isOdEnabled;

    public CurrentAccount(int accNo, String accName, double balance, boolean isOdEnabled) {
        super(accNo, accName, "CURRENT", balance, true);
        this.isOdEnabled = isOdEnabled;
    }

    public boolean isOdEnabled() {
        return isOdEnabled;
    }

    public void setOdEnabled(boolean odEnabled) {
        isOdEnabled = odEnabled;
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit must be positive");
        }
        accBalance += amount;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid withdrawal amount");
        }
        if (amount > 25000) {
            throw new InvalidAmountException("Current account allows max 25000 per transaction");
        }
        if (amount > accBalance && !isOdEnabled) {
            throw new InvalidAmountException("Overdraft not enabled");
        }
        accBalance -= amount;
    }
}


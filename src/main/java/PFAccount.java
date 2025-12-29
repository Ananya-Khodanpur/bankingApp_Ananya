public class PFAccount extends Accounts {

    public PFAccount(int accNo, String accName, double balance) {
        super(accNo, accName, "PF", balance, true);
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
        double maxWithdraw = accBalance * 0.70;
        if (amount > maxWithdraw) {
            throw new InvalidAmountException("PF allows withdrawal up to 70% only");
        }
        accBalance -= amount;
    }
}

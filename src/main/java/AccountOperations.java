public interface AccountOperations {
    double checkBalance();
    void deposit(double amount) throws InvalidAmountException;
    void withdraw(double amount) throws InvalidAmountException;
}

import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Accounts account = null;

        try {
            System.out.println("----- Welcome to Banking Application -----");

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            sc.nextLine(); // consume newline
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            System.out.println("Select Account Type:");
            System.out.println("1. Savings");
            System.out.println("2. Current");
            System.out.println("3. PF");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account = new SavingsAccount(accNo, name, balance);
                    break;

                case 2:
                    System.out.print("Enable Overdraft? (true/false): ");
                    boolean od = sc.nextBoolean();
                    account = new CurrentAccount(accNo, name, balance, od);
                    break;

                case 3:
                    account = new PFAccount(accNo, name, balance);
                    break;

                default:
                    System.out.println("Invalid account type selected");
                    System.exit(0);
            }

            boolean exit = false;

            while (!exit) {
                System.out.println("\n----- Menu -----");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Current Balance: " + account.checkBalance());
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depAmt = sc.nextDouble();
                        account.deposit(depAmt);
                        System.out.println("Deposit successful");
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withAmt = sc.nextDouble();
                        account.withdraw(withAmt);
                        System.out.println("Withdrawal successful");
                        break;

                    case 4:
                        exit = true;
                        System.out.println("Thank you for using Banking App");
                        break;

                    default:
                        System.out.println("Invalid option");
                }
            }

        } catch (InvalidAmountException e) {
            System.out.println("Transaction Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter correct values.");
        } finally {
            sc.close();
        }
    }
}

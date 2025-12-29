import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exitApp = false;

        while (!exitApp) {
            try {
                System.out.println("\n===== BANKING APPLICATION =====");
                System.out.println("1. Create Account");
                System.out.println("2. Exit");
                System.out.print("Choose option: ");

                int mainChoice = sc.nextInt();

                if (mainChoice == 2) {
                    exitApp = true;
                    System.out.println("Thank you for using the Banking Application.");
                    break;
                }

                if (mainChoice != 1) {
                    throw new InvalidAccountTypeException("Invalid main menu option");
                }

                // -------- Account Creation --------
                System.out.println("\nSelect Account Type:");
                System.out.println("1. Savings");
                System.out.println("2. Current");
                System.out.println("3. PF");
                System.out.print("Enter choice: ");

                int accTypeChoice = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Account Holder Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();

                Accounts account;

                switch (accTypeChoice) {
                    case 1:
                        account = new SavingsAccount(
                                AccountNumberGenerator.generateSavingsAccNo(),
                                name, balance);
                        break;

                    case 2:
                        System.out.print("Enable Overdraft (true/false): ");
                        boolean odEnabled = sc.nextBoolean();
                        account = new CurrentAccount(
                                AccountNumberGenerator.generateCurrentAccNo(),
                                name, balance, odEnabled);
                        break;

                    case 3:
                        account = new PFAccount(
                                AccountNumberGenerator.generatePfAccNo(),
                                name, balance);
                        break;

                    default:
                        throw new InvalidAccountTypeException("Invalid account type selected");
                }

                System.out.println("\nAccount Created Successfully!");
                System.out.println("Account No: " + account.getAccNo());
                System.out.println("Account Type: " + account.getAccType());

                // -------- Account Operations Menu --------
                boolean exitAccountMenu = false;

                while (!exitAccountMenu) {
                    try {
                        System.out.println("\n----- Account Menu -----");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit");
                        System.out.println("3. Withdraw");
                        System.out.println("4. Exit Account");
                        System.out.print("Choose option: ");

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
                                exitAccountMenu = true;
                                System.out.println("Exiting account menu...");
                                break;

                            default:
                                System.out.println("Invalid option");
                        }

                    } catch (InvalidAmountException e) {
                        System.out.println("Transaction Error: " + e.getMessage());
                    }
                }

            } catch (InvalidAccountTypeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                sc.nextLine(); // clear buffer
            }
        }

        sc.close();
    }
}

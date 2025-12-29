import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\n--- Create New Account ---");
                System.out.println("1. Savings");
                System.out.println("2. Current");
                System.out.println("3. PF");
                System.out.println("4. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();

                if (choice == 4) {
                    exit = true;
                    System.out.println("Application Closed.");
                    break;
                }

                sc.nextLine();
                System.out.print("Enter Account Holder Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();

                Accounts account;

                switch (choice) {
                    case 1:
                        account = new SavingsAccount(
                                AccountNumberGenerator.generateSavingsAccNo(),
                                name, balance);
                        break;

                    case 2:
                        System.out.print("Enable Overdraft (true/false): ");
                        boolean od = sc.nextBoolean();
                        account = new CurrentAccount(
                                AccountNumberGenerator.generateCurrentAccNo(),
                                name, balance, od);
                        break;

                    case 3:
                        account = new PFAccount(
                                AccountNumberGenerator.generatePfAccNo(),
                                name, balance);
                        break;

                    default:
                        throw new InvalidAccountTypeException("Invalid account type selected");
                }

                System.out.println("Account Created Successfully");
                System.out.println("Account No: " + account.getAccNo());
                System.out.println("Account Type: " + account.getAccType());
                System.out.println("Balance: " + account.checkBalance());

            } catch (InvalidAccountTypeException | InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}

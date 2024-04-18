import java.util.Scanner;

public class ATMSystem {
    private double balance;

    public ATMSystem(double initialBalance) {
        this.balance = initialBalance;
    }

    public void displayMenu() {
        System.out.println("ATM Machine");
        System.out.println("Choose 1 for Withdraw");
        System.out.println("Choose 2 for Depoist");
        System.out.println("Choose 3 for Check Balance");
        System.out.println("Choose 4 for Exit");
        System.out.print("Choose the operation:");
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void withdrawCash(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance -= amount;
            System.out.println("Your Money has been Successfully Withdrawal");
        }
    }

    public void depositMoney(double amount) {
        balance += amount;
        System.out.println("Your Money has been Successfully depoisted");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Balance: ");
        double initialBalance = scanner.nextDouble();

        ATMSystem atm = new ATMSystem(initialBalance);

        int choice;
        do {
            atm.displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
				    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdrawCash(withdrawAmount);
                    break;
                case 2:
					System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.depositMoney(depositAmount);
                    break;
                case 3:
					atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you for using the ATM System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
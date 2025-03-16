import java.util.Scanner;
class ATM{
    private BankAccount account;
    public ATM(BankAccount account){
        this.account = account;
    }
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nATM Menu:");
            System.out.println("1.check balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdrawal");
            System.out.println("4.Exit");
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Your balance: $"+account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Thankyou for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

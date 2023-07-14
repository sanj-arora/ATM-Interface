import java.util.Scanner;

class BankAccount {
    private String user;
    private String pass;
    private String accountNo;
    private float balance = 100000f;
    private int trans = 0;
    private StringBuilder transactionHistory = new StringBuilder();

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username: ");
        user = sc.nextLine();
        System.out.print("Enter Password: ");
        pass = sc.nextLine();
        System.out.print("Enter Account Number: ");
        accountNo = sc.nextLine();
        System.out.println("\nRegistration completed. Kindly login.\n\n");
    }

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        boolean islog = false;

        while (!islog) {
            System.out.print("\nEnter Your username: ");
            String user = sc.nextLine();
            if (user.equals(user)) {
                while (!islog) {
                    System.out.print("Enter Your password: ");
                    String inputpass = sc.nextLine();
                    if (inputpass.equals(pass)) {
                        System.out.println("Login successful.\n\n");
                        islog = true;
                    } else {
                        System.out.println("Incorrect password");
                    }
                }
            } else {
                System.out.println("user not found");
            }
        }
        return islog;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        float amt = sc.nextFloat();
        if (amt > 0) {
            if (balance >= amt) {
                trans++;
                balance -= amt;
                System.out.println("Withdrawal Successful\n\n");
                String str = amt + " Rs Withdrawn\n";
                transactionHistory.append(str);
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        float amt = sc.nextFloat();
        if (amt > 0) {
            trans++;
            balance += amt;
            System.out.println("Deposit Successful\n\n");
            String str = amt + " Rs deposited\n";
            transactionHistory.append(str);
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.print("Enter amount to transfer: ");
        float amt = sc.nextFloat();
        if (amt > 0) {
            if (balance >= amt) {
                trans++;
                balance -= amt;
                System.out.println("Successfully Transferred to " + recipient + "\n\n");
                String str = amt + " Rs transferred to " + recipient + "\n";
                transactionHistory.append(str);
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance + " Rs\n\n");
    }

    public void transHistory() {
        if (trans == 0) {
            System.out.println("Empty");
        } else {
            System.out.println("Transaction History:\n" + transactionHistory.toString());
        }
    }
}

public class AtmInterface {
    static int reg = 1;
    static int exit = 2;
    static int log = 1;
    static int menuexit = 6;

    public static void main(String[] args) {
        System.out.println("\n--------- WELCOME ---------\n");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();

        if (choice == reg) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.register();

            while (true) {
                System.out.println("\n1. Login");
                System.out.println("2. Exit");
                System.out.print("Enter Your Choice: ");
                int menuChoice = sc.nextInt();

                if (menuChoice == log) {
                    if (bankAccount.login()) {
                        boolean isFinished = false;

                        while (!isFinished) {
                            System.out.println("1. Withdraw");
                            System.out.println("2. Deposit");
                            System.out.println("3. Transfer");
                            System.out.println("4. Check Balance");
                            System.out.println("5. Transaction History");
                            System.out.println("6. Exit");
                            System.out.print("Enter Your Choice: ");
                            int optionChoice = sc.nextInt();

                            switch (optionChoice) {
                                case 1:
                                    bankAccount.withdraw();
                                    break;
                                case 2:
                                    bankAccount.deposit();
                                    break;
                                case 3:
                                    bankAccount.transfer();
                                    break;
                                case 4:
                                    bankAccount.checkBalance();
                                    break;
                                case 5:
                                    bankAccount.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}

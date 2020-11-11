
/*
*   A Simple ATM Program using java.
*   @Author: Malay Bhavsar
*/

// Importing the java tools.
import java.util.*;
import java.io.File;
import java.io.FileWriter;

class Account {
    static String acc;
    static String name;
    static int pin;
    static String address;
    static String type;
    static float balance;

    public static void read_acc(String acc) {
        // Read a file.
        try {
            File myAcc = new File("./acc:" + acc + ".txt");
            Scanner myReader = new Scanner(myAcc);
            name = myReader.next();
            pin = myReader.nextInt();
            balance = Float.parseFloat(myReader.next());
            myReader.close();
        } catch (Exception e) {
            System.out.println("[ERROR]: No Such Account Exist!");
        }
    }

    public static void write_acc(String acc) {
        // Write to file.
        try {
            FileWriter myWriter = new FileWriter("./acc:" + acc + ".txt");
            myWriter.write(name + "\n");
            myWriter.write(String.valueOf(pin) + "\n");
            myWriter.write(Float.toString(balance) + "\n");
            myWriter.close();
            System.out.println("Thank you for using our service!");
        } catch (Exception e) {
            System.out.println("Some error occoured!!");
        }
    }

}

public class ATM {
    // static Account Obj = new Account();
    static Scanner sc = new Scanner(System.in);

    public static void header() {
        // Print intro.
        System.out.println("\n----- LEO-Bank -----");
        System.out.print("(1) Deposit\n(2) Withdraw\n(3) Check Balance\n(4) New Account\nOption: ");
    }

    public static void deposit() {
        // Function to deposit the money.
        System.out.print("Account No: ");
        String acc = sc.next();
        Account.read_acc(acc);
        System.out.print("Pin: ");
        int upin = sc.nextInt();
        if (upin == Account.pin) {
            System.out.print("Amount: ");
            float amount = sc.nextFloat();
            Account.balance += amount;
            System.out.println("Your New Balance is $" + Account.balance);
            Account.write_acc(Account.acc);
        } else {
            System.out.println("Incorrect Pin. Try again!");
        }
        sc.close();
    }

    public static void withdraw() {
        // withdraw money.
        System.out.print("Account No: ");
        Account.acc = sc.next();
        Account.read_acc(Account.acc);
        System.out.print("Pin: ");
        int upin = sc.nextInt();
        if (upin == Account.pin) {
            System.out.print("Amount: ");
            float amount = sc.nextFloat();
            if (amount > Account.balance) {
                System.out.println("You don't have sufficient balance. Current Balance is $" + Account.balance);
            } else {
                Account.balance -= amount;
                System.out.println("Your new Balance is $" + Account.balance);
            }
            Account.write_acc(Account.acc);
        } else {
            System.out.println("Incorrect Pin. Try again!");
        }
        sc.close();
    }

    public static void check_balance() {
        // Check your balance.
        System.out.print("Account No: ");
        String acc = sc.next();
        Account.read_acc(acc);
        System.out.print("Pin: ");
        int upin = sc.nextInt();
        if (upin == Account.pin) {
            System.out.println("Your current balance is $" + Account.balance);
        } else {
            System.out.println("Incorrect Pin. Try again!");
        }
        sc.close();
    }

    public static void new_acc() {
        // This will make a new accont for you.
        if (Account.acc != "") {
            Account.acc = "";
        }
        System.out.print("Account No: ");
        Account.acc = sc.next();
        System.out.print("Pin: ");
        Account.pin = sc.nextInt();
        System.out.print("Name: ");
        Account.name = sc.next();
        System.out.print("Balance: ");
        Account.balance = sc.nextFloat();
        sc.close();
        Account.write_acc(Account.acc);
    }

    public static void main(String args[]) {
        header();
        int option = sc.nextInt();
        switch (option) {
            case 1:
                deposit();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                check_balance();
                break;
            case 4:
                new_acc();
                break;
            default:
                System.out.println("Please select a proper option!");
                break;
        }
        sc.close();
    }
}
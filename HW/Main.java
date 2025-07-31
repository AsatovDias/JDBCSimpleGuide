package JDBC.MySQLConnection.HW;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connector db = new Connector();
        db.connect();
        System.out.println("Enter your card number: ");
        int cardNum = sc.nextInt();
        System.out.print("Enter your pinCode: ");
        int pinCode = sc.nextInt();

        if(db.auth(cardNum, pinCode)) {
            User user =  db.getUser(cardNum);
            System.out.println("Hello " + user.getName() + " " + user.getSurname());
            while(true) {
                System.out.println("[1] Balance");
                System.out.println("[2] Cash IN");
                System.out.println("[3] Cash OUT");
                System.out.println("[0] exit");
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println(db.getTotalBalance(cardNum, pinCode));
                }else {
                    break;
                }
            }
        }else{
            System.out.println("Invalid PinCode");
        }

    }

}


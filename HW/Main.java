package JDBC.MySQLConnection.HW;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connector db = new Connector();

        System.out.println("Enter your card number: ");
        int cardNum = sc.nextInt();
        User user = db.getUser(cardNum);
        if(user != null){
            System.out.println("Hello " + user.getName() + " " + user.getSurname());
            while(true){
                System.out.println("[1] Balance");
                System.out.println("[2] Cash IN");
                System.out.println("[3] Cash OUT");
                System.out.println("[0] exit");

            }
        }

    }

}

import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int choice;
        Scanner kbd = new Scanner(System.in);
        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                       INFIX TO POSTFIX &");
            System.out.println("                        POSTFIX TO INFIX");
            System.out.println("                           CONVERTER");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1) Convert from Postfix to Infix");
            System.out.println("2) Convert from Infix to Postfix");
            System.out.println("3) Exit");
            System.out.print("Select the number corresponding to your choice: ");

            choice = kbd.nextInt();

            switch (choice) {
                case 1:
                    PostfixToInfix obj1 = new PostfixToInfix();
                    System.out.print("Postfix : \t");
                    String postfix = kbd.next();
                    System.out.print("Infix : \t"+obj1.convert(postfix));
                    System.out.println("");
                    break;
                case 2:
                    InfixToPostfix obj2 = new InfixToPostfix();
                    System.out.print("Infix : \t");
                    String infix = kbd.next();
                    System.out.print("Postfix : \t"+obj2.convert(infix));
                    System.out.println("");
                    break;
                case 3:
                    System.exit(0);
            }
        }while(choice != 3);
    }
}


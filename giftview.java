package lab05.giftshop;

import java.util.Scanner;

public class giftview {
    public static void main(String[] args) {
        giftController objControl = new giftController();
        Scanner input = new Scanner(System.in);
        int choice;
do {

    System.out.println("!!!Welcome to book Gift shop!!!");
    System.out.println("=== What do you want ===");
    System.out.println("1.Display all books in library");
    System.out.println("2.Add book to library");
    System.out.println("3.Delete books in library");
    choice = input.nextInt();
    switch (choice) {
        case 1:
            objControl.select();
            break;
        case 2:
            objControl.addBook();
            break;
        case 3:
            objControl.delete();
            break;
        default:
            System.out.println("Invalid choice");
            break;
    }
}
while (choice != 4) ;
    }
}




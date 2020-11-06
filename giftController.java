package lab05.giftshop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class giftController {
    List<gift> listObj = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    void select() {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookself",
                "root","");
            Statement stmt = conn.createStatement();) {
            String sqlSelect = "Select * from books";
            System.out.println("The sql statement is: " + sqlSelect);
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            while (rSet.next()){
                System.out.println(rSet.getInt("bookID") + ", "
                + rSet.getString("BookName") + ", "
                +rSet.getString("author") + ", "
                +rSet.getDouble("price") + ", "
                +rSet.getInt("qty"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void insertBook(gift qua){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookself",
                "root",
                "");
            Statement stmt = conn.createStatement();){
            String sqlInsert = "Insert into books values ("+qua.getId()+",'"
                    +qua.getName()+"',"
                    +"'"+qua.getAuthor()+"',"
                    +qua.getPrice()+","
                    +qua.getQty()+ ");";
            System.out.println("The sql statement is: " + sqlInsert);
            listObj.add(qua);
            stmt.executeUpdate(sqlInsert);

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    void delete(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookself",
                "root", "");
             Statement stmt = conn.createStatement();) {
            String sqlDelete = "Delete From books where bookID = " + id;
            System.out.println("The sql statement is: " + sqlDelete);
            stmt.executeUpdate(sqlDelete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void addBook(){
        gift objGift = new gift();
        System.out.println("Enter book id:" );
        int id = input.nextInt();
        objGift.setId(id);

        System.out.println("Enter book's name: ");
        String name = input.nextLine();
        objGift.setName(input.nextLine());

        System.out.println("Enter book's author: ");
        String authorName = input.nextLine();
        objGift.setAuthor(authorName);

        System.out.println("Enter book's price: ");
        double price = input.nextFloat();
        objGift.setPrice(price);

        System.out.println("Enter amount of book: ");
        int amt = input.nextInt();
        objGift.setQty(amt);
        giftController objControl = new giftController();
        objControl.insertBook(objGift);

        System.out.println("Insert success");
    }
    void delete(){
        System.out.println("Enter book's id you want to delete: ");
        int id = input.nextInt();
        delete(id);
        System.out.println("Delete success");
    }
}

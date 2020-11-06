package lab05;

import java.sql.*;

public class jdbcInsertTest {
    public static void main(String[] args) {
        try (//step 1: allocate a database connection
             Connection conn = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/bookself", "root", "");
             Statement stmt = conn.createStatement();
        ) {
            //Delete records with id >= 3000 and id < 4000
            String sqlDelete = "delete from books where bookID >= 3000 and bookID < 4000 ";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records inserted \n");

            //Insert a record
            String sqlInsert = "insert into books values (3001,'Gone Fishing','Kumar',11.11,11)";
            System.out.println("The sql statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            //Insert multiple records
            sqlInsert = "insert into books values "
                    + "(3002, 'Gone Fishing 2', 'Kumar', 22.22, 22),"
                    + "(3003, 'Gone Fishing 3', 'Kumar', 33.33, 33)";
            System.out.println("The sql statement is: " + sqlInsert);
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted. \n");

            String strSelect = "select * from books";
            System.out.println("The sql statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(rset.getInt("BookID") + ", "
                        + rset.getString("BookName") + ", "
                        + rset.getString("author") + ", "
                        + rset.getDouble("price") + ", "
                        + rset.getInt("qty"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    }

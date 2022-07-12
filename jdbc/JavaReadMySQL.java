import java.sql.*;

public class JavaReadMySQL {
   static final String DB_URL = "jdbc:mysql://localhost/test";
   static final String USER = "root";
   static final String PASS = "";
   static final String QUERY = "SELECT * FROM products";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.println(", Product: " + rs.getString("product"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}

/*
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;
*/
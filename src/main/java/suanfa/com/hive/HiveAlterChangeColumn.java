package suanfa.com.hive;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveAlterChangeColumn {

    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws Exception {

        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive://localhost:10000/userdb", "", "");

        // create statement
        Statement stmt = con.createStatement();

        // execute statement
        stmt.executeQuery("ALTER TABLE employee CHANGE name ename String;");
        stmt.executeQuery("ALTER TABLE employee CHANGE salary salary Double;");

        System.out.println("Change column successful.");
        con.close();
    }
}

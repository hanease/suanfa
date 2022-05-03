package suanfa.com.hive;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveAlterAddColumn {

    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws Exception {

        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive://localhost:10000/userdb", "", "");

        // create statement
        Statement stmt = con.createStatement();

        // execute statement
        stmt.executeQuery("ALTER TABLE employee ADD COLUMNS " + " (dept STRING COMMENT 'Department name');");
        //// execute statement
        //      stmt.executeQuery("ALTER TABLE employee REPLACE COLUMNS "
        //         +" (eid INT empid Int,"
        //         +" ename STRING name String);");

        System.out.println("Add column successful.");

        con.close();
    }
}

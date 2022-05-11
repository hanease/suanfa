package suanfa.com.hive;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveQLGroupBy {

    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws Exception {

        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.
                getConnection("jdbc:hive://localhost:10000/userdb", "", "");

        // create statement
        Statement stmt = con.createStatement();

        // execute statement
        //Resultset res = stmt.executeQuery(“SELECT Dept,count(*) ” + “FROM employee GROUP BY DEPT; ”);
        System.out.println(" Dept \t count(*)");

        /*while (res.next()) {
            System.out.println(res.getString(1) + " " + res.getInt(2));
        }*/
        con.close();
    }
}

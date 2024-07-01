package mylib;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hoang
 */
public class DBUtil {

    public static Connection makeConnection() throws Exception {
        Connection cn = null;
        String IP = "localhost";
        String instanceName = "COCONUT-16";
        String port = "1433";
        String uid = "sa";
        String pwd = "12345";
        String db = "healthy eating planner";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port
                + ";databasename=" + db + ";user=" + uid + ";password=" + pwd;
        Class.forName(driver);
        cn = DriverManager.getConnection(url);
        return cn;
    }
}


package ConnectionProvider;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Packiyaraj
 */
public class ConnectionProvider {
    Connection con=null;
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospice","root","");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
   
}

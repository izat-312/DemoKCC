package SQLselenium;

import java.sql.*;

public class insertSQL {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/IDSDATA","root","chicago312");
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into homedepot values('Almanbet','1234456')");

    }
}

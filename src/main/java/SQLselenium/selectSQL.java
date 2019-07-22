package SQLselenium;

import java.sql.*;

public class selectSQL {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/IDSDATA","root","chicago312");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from homedepot");
        while (resultSet.next()){
            System.out.print(resultSet.getString("name")+" ");
            System.out.println(resultSet.getString("password"));
        }
    }
}

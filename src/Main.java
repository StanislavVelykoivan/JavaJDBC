import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the PostgreSQL database successfully!");
            Statement st = connection.createStatement();
            String query = "SELECT * FROM student;";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                String usersData = rs.getInt(1) + " " + rs.getString(2);
                System.out.println(usersData);
            }

            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
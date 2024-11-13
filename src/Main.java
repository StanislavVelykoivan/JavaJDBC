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

            String name = "Bob Brown";
            String query = "INSERT INTO student (name) VALUES (?);";

            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1,name);

            int count = st.executeUpdate();

            System.out.println(count + " row/s affected");

            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
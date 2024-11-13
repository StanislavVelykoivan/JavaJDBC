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
            String query = "SELECT * FROM student WHERE student_id = 3;";
            ResultSet rs =  st.executeQuery(query);
            rs.next();
            String name = rs.getString("name");
            System.out.println(name);
            st.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
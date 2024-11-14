import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class StudentDAO {
    public Student getStudent(int index) throws ClassNotFoundException, SQLException {
        Student s = new Student();
        String query = "SELECT name FROM student WHERE student_id = " + index + ";";
        s.index = index;

        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        rs.next();
        String name = rs.getString("name");
        s.name = name;

        return s;
    }
}

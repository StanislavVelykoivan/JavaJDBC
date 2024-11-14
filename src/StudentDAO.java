import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class StudentDAO {

    Connection con = null;

    public void connect() {
        try {
            Dotenv dotenv = Dotenv.load();

            String url = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
        }
    }

    public Student getStudent(int index) throws ClassNotFoundException, SQLException {

        String query = "SELECT name FROM student WHERE student_id = " + index + ";";


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
        Student s = new Student(name);
        s.index = index;

        return s;
    }

    public void addStudent(Student s) throws  SQLException {
        String name = s.name;
        String query = "INSERT INTO student (name) VALUES (?);";
        connect();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.executeUpdate();
    }
}

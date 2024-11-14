import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        StudentDAO dao = new StudentDAO();
        Student s = new Student("Jon Silver");

        dao.addStudent(s);
    }
}
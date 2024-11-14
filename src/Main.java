import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        StudentDAO dao = new StudentDAO();
        Student s1 = dao.getStudent(3);
        System.out.println(s1.name);
    }
}
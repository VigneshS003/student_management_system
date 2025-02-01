package EMS;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void addStudent(Student student) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?, ?)")) {

            stmt.setInt(1, student.getRegno());
            stmt.setString(2, student.getName());
            stmt.setDouble(3, student.getCgpa());
            stmt.setString(4, student.getAddress());
            stmt.setString(5, student.getPhone());

            stmt.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("regno"),
                        rs.getString("name"),
                        rs.getDouble("cgpa"),
                        rs.getString("address"),
                        rs.getString("phone")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void updateStudent(int regno, String newName, double newCgpa, String newAddress, String newPhone) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE students SET name=?, cgpa=?, address=?, phone=? WHERE regno=?")) {

            stmt.setString(1, newName);
            stmt.setDouble(2, newCgpa);
            stmt.setString(3, newAddress);
            stmt.setString(4, newPhone);
            stmt.setInt(5, regno);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int regno) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM students WHERE regno=?")) {

            stmt.setInt(1, regno);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


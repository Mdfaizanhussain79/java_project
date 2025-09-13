import java.sql.*;

public class StudentRegistration {
    public void registerStudent(String name, String dob, String email, String address, int marks) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO Students (Name, DOB, Email, Address, Marks, Status) VALUES (?, ?, ?, ?, ?, 'Applied')";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, dob);
            pst.setString(3, email);
            pst.setString(4, address);
            pst.setInt(5, marks);
            pst.executeUpdate();
            System.out.println("Student registered successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

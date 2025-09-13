import java.sql.*;

public class ApplicationManager {
    public void applyCourse(int studentID, int courseID, int marks) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO Applications (StudentID, CourseID, Marks, Status) VALUES (?, ?, ?, 'Pending')";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentID);
            pst.setInt(2, courseID);
            pst.setInt(3, marks);
            pst.executeUpdate();
            System.out.println("Course application submitted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.io.FileWriter;
import java.sql.*;
public class ListExporter {
    public void exportAdmissionList(int courseID) {
        try (Connection con = DBConnection.getConnection();
             FileWriter writer = new FileWriter("admission_list.csv")) {
            String sql = "SELECT s.StudentID, s.Name, a.Status FROM Students s JOIN Applications a ON s.StudentID=a.StudentID WHERE a.CourseID=? AND a.Status='Approved'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, courseID);
            ResultSet rs = pst.executeQuery();
            writer.append("StudentID,Name,Status\n");
            while (rs.next()) {
                writer.append(rs.getInt("StudentID") + "," + rs.getString("Name") + "," + rs.getString("Status") + "\n");
            }
            System.out.println("Admission list exported to admission_list.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

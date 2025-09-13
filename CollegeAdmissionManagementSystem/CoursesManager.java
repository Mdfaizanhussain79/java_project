import java.sql.*;
public class CoursesManager {
    public void addCourse(String name, int cutoff, int seats) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO Courses (CourseName, Cutoff, SeatsAvailable) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, cutoff);
            pst.setInt(3, seats);
            pst.executeUpdate();
            System.out.println("Course added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void displayCourses() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Courses";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println("ID: "+rs.getInt(1)+", Name: "+rs.getString(2)+", Cutoff: "+rs.getInt(3)+", Seats: "+rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

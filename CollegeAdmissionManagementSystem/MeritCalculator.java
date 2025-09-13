// import java.sql.*;
// import java.util.*;
// public class MeritCalculator {
//     public List<Integer> calculateMeritList(int courseID) {
//         List<Integer> selected = new ArrayList<>();
//         try (Connection con = DBConnection.getConnection()) {
//             String sql = "SELECT a.StudentID, a.Marks, c.Cutoff, c.SeatsAvailable FROM Applications a JOIN Courses c ON c.CourseID=a.CourseID WHERE a.CourseID=? AND a.Status='Pending' AND a.Marks>=c.Cutoff ORDER BY a.Marks DESC LIMIT c.SeatsAvailable";
//             PreparedStatement pst = con.prepareStatement(sql);
//             pst.setInt(1, courseID);
//             ResultSet rs = pst.executeQuery();
//             while (rs.next()) {
//                 selected.add(rs.getInt("StudentID"));
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return selected;
//     }
// }
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeritCalculator {
    public List<Integer> calculateMeritList(int courseID) {
        List<Integer> selectedStudents = new ArrayList<>();
        int seatsAvailable = 0;

        try (Connection con = DBConnection.getConnection()) {
            // Step 1: Get SeatsAvailable for the course
            String seatQuery = "SELECT SeatsAvailable FROM Courses WHERE CourseID = ?";
            PreparedStatement seatStmt = con.prepareStatement(seatQuery);
            seatStmt.setInt(1, courseID);
            ResultSet seatRs = seatStmt.executeQuery();
            if (seatRs.next()) {
                seatsAvailable = seatRs.getInt("SeatsAvailable");
            }

            // Step 2: Fetch top students up to seatsAvailable number, ordered by marks and passing cutoff
            String sql = "SELECT a.StudentID, a.Marks FROM Applications a JOIN Courses c ON c.CourseID = a.CourseID " +
                         "WHERE a.CourseID = ? AND a.Status = 'Pending' AND a.Marks >= c.Cutoff " +
                         "ORDER BY a.Marks DESC LIMIT ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, courseID);
            pst.setInt(2, seatsAvailable);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                selectedStudents.add(rs.getInt("StudentID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectedStudents;
    }
}

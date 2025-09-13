import java.sql.*;
public class AdminPanel {
    public void updateApplicationStatus(int appID, String status) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE Applications SET Status=? WHERE AppID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, status);
            pst.setInt(2, appID);
            pst.executeUpdate();
            System.out.println("Application " + status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


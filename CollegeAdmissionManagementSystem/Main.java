import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRegistration studentReg = new StudentRegistration();
        ApplicationManager appManager = new ApplicationManager();
        CoursesManager courseManager = new CoursesManager();
        MeritCalculator meritCalc = new MeritCalculator();
        AdminPanel adminPanel = new AdminPanel();
        ListExporter exporter = new ListExporter();

        while (true) {
            System.out.println("\n--- College Admission System ---");
            System.out.println("1. Register Student");
            System.out.println("2. Add Course");
            System.out.println("3. Display Courses");
            System.out.println("4. Apply for Course");
            System.out.println("5. Calculate Merit List");
            System.out.println("6. Admin Approve/Reject");
            System.out.println("7. Export Admission List");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dob = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Address: ");
                    String addr = sc.nextLine();
                    System.out.print("Marks: ");
                    int marks = sc.nextInt(); sc.nextLine();
                    studentReg.registerStudent(name, dob, email, addr, marks); break;
                case 2:
                    System.out.print("Course Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Cutoff: ");
                    int cutoff = sc.nextInt();
                    System.out.print("Seats: ");
                    int seats = sc.nextInt(); sc.nextLine();
                    courseManager.addCourse(cname, cutoff, seats); break;
                case 3:
                    courseManager.displayCourses(); break;
                case 4:
                    System.out.print("Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Course ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Marks: ");
                    int marksApply = sc.nextInt(); sc.nextLine();
                    appManager.applyCourse(sid, cid, marksApply); break;
                case 5:
                    System.out.print("Course ID: ");
                    int meritCourseID = sc.nextInt(); sc.nextLine();
                    List<Integer> meritList = meritCalc.calculateMeritList(meritCourseID);
                    System.out.println("Selected Students: " + meritList); break;
                case 6:
                    System.out.print("App ID: ");
                    int appID = sc.nextInt(); sc.nextLine();
                    System.out.print("Approve or Reject? (Approved/Rejected): ");
                    String status = sc.nextLine();
                    adminPanel.updateApplicationStatus(appID, status); break;
                case 7:
                    System.out.print("Course ID: ");
                    int exportCID = sc.nextInt(); sc.nextLine();
                    exporter.exportAdmissionList(exportCID); break;
                case 8:
                    System.out.println("Exiting...");
                    sc.close(); System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

import java.util.Scanner;

public class AttendanceTrackerApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name.");
        String studentName = sc.nextLine();
        System.out.println("Enter your Roll no.");
        int rollNumber = sc.nextInt();
        System.out.println("Enter your Division.");
        String division = sc.next();
        System.out.println("Enter your Year.");
        String year = sc.next();


        System.out.println("Enter Subject Name");
        String subjectName = sc.next();


        System.out.println("Enter Time schedule of Lecture");
        String time = sc.next();


        System.out.println("Enter the particular Day of Lecture");
        String dayOfWeek = sc.next();


        Student s1 = new Student(studentName, rollNumber, division, year);

        Subject subject = new Subject(subjectName);

        s1.addSubject(subject);

        TimetableEntry timetableEntry = new TimetableEntry(time, dayOfWeek, subject);
        s1.createTimetable(timetableEntry);


        System.out.println("Enter Date");
        String date = sc.next();

        System.out.println("Enter true for present and false for absent");
        boolean present = sc.nextBoolean();

        AttendanceStatus attendanceStatus = new AttendanceStatus(date, subject, present);
        s1.addAttendanceRecord(attendanceStatus);

        s1.viewAttendanceReport(subject);


    }
}

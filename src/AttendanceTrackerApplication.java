import java.util.Scanner;

public class AttendanceTrackerApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int i = 1;

        do{
            System.out.println("Menu");
            System.out.println("1. Add Subject");
            System.out.println("2. View Subject");
            System.out.println("Exit");

            switch ()
        }while (i<=3);{
            System.out.println();
        }









//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your Name.");
//        String studentName = sc.nextLine();
//        System.out.println("Enter your Roll no.");
//        int rollNumber = sc.nextInt();
//        System.out.println("Enter your Division.");
//        String division = sc.next();
//        System.out.println("Enter your Year.");
//        String year = sc.next();
//
//        System.out.println("Enter Subject Name");
//        String subjectName = sc.next();
//
//        System.out.println("Enter Time schedule of Lecture");
//        String time = sc.next();
//
//        System.out.println("Enter the particular Day of Lecture");
//        String dayOfWeek = sc.next();
//
//        System.out.println("Enter Date");
//        String date = sc.next();
//
//        System.out.println("Enter true for present and false for absent");
//        boolean present = sc.nextBoolean();
//
//        Student student = new Student(studentName, rollNumber, division, year);
//
//        Subject subject = new Subject(subjectName);
//        student.addSubject(subject);
//
//        TimetableEntry timetableEntry = new TimetableEntry(time, dayOfWeek, subject);
//        student.createTimetable(timetableEntry);
//
//        AttendanceStatus attendanceStatus = new AttendanceStatus(date, subject, present);
//        student.addAttendanceRecord(attendanceStatus);
//
//        student.viewAttendanceReport();
//
//        Subject subject1 = new Subject("Java");
//        Subject subject2 = new Subject("Java");
//        System.out.println(subject1.equals(subject2));
//
//        int i = sc.nextInt();
//        switch (i){
//            case 1:
//                System.out.println("Add subject");
//                student.addSubject(subject);
//                break;
//
//            case 2:
//                System.out.println("View Subject");
//                student.viewSubject();
//                break;
//
//            case 3:
//                System.out.println("Create TimetableEntry");
//                student.createTimetable(timetableEntry);
//                break;
//
//            case 4:
//                System.out.println("Add Attendance");
//                student.addAttendanceRecord(attendanceStatus);
//                break;
//
//            case 5:
//                System.out.println("View Attendance");
//                student.viewAttendanceReport();
//                break;
//
//            default:
//                System.out.println("Exit");
//                break;
//        }
    }
}

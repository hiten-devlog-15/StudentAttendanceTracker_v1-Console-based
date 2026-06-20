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

        Student student = new Student(studentName, rollNumber, division, year);

        boolean keepRunning = true;

        do{
            System.out.println("Menu");
            System.out.println("1. Add Subject");
            System.out.println("2. View Subject");
//            System.out.println("");
            System.out.println("3. Add Attendance");
            System.out.println("4. View Attendance Report");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            Subject subject = new Subject(studentName); //As subject is required for multiple cases we cant declare it inside any case.
            //As this will reduce the scope of our object reference.

            switch (choice){
                case 1:
                    System.out.println("Enter Subject Name");
                    String subjectName = sc.next();
                    student.addSubject(subject);

                    break;

                case 2:
                    student.viewSubjects();
                    break;

                case 3:
                    System.out.println("Enter Date");
                    String date = sc.next();
                    System.out.println("Present = true & Absent = false");
                    boolean present = sc.nextBoolean();
                    System.out.println("Enter subject index");

                    Subject subjectInList = student.getSubjectAtIndex().get(i);
                    AttendanceStatus attendanceStatus = new AttendanceStatus(date, subjectInList, present);
                    if(student.getSubjectAtIndex().){
                        System.out.println("Add a subject First");
                    }
                    student.addAttendanceRecord(attendanceStatus);
                    break;

                case 4:
                    student.viewAttendanceReport();
                    break;

                case 5:
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Number out of Range.");
                    break;
            }
        }while (keepRunning);


//        Scanner sc = new Scanner(System.in);

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



//        TimetableEntry timetableEntry = new TimetableEntry(time, dayOfWeek, subject);
//        student.createTimetable(timetableEntry);
//
//        AttendanceStatus attendanceStatus = new AttendanceStatus(date, subject, present);
//        student.addAttendanceRecord(attendanceStatus);

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
//       }
    }
}

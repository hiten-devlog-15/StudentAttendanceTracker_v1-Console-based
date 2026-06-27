import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

        do {
            System.out.println("Menu");
            System.out.println("1. Add Subject");
            System.out.println("2. View Subject");
            System.out.println("3. Create Timetable Entry");
            System.out.println("4. View Timetable");
            System.out.println("5. Add Attendance");
            System.out.println("6. View Attendance Report");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            //As subject is required for multiple cases we cant declare it inside any case.
            //As this will reduce the scope of our object reference.

            switch (choice) {
                case 1:
                    System.out.println("Enter Subject Name");
                    String subjectName = sc.next();
                    Subject subject = new Subject(subjectName.toUpperCase());
                    student.addSubject(subject);
                    break;

                case 2:
                    student.viewSubjects();
                    break;

                case 3:
                    student.showSubjects();
                    System.out.println("Enter Subject index");
                    int i = sc.nextInt();
                    Subject chooseSubject = null;
                    if (i >= 0 && i < student.getSubjectList().size()) {
                        chooseSubject = student.getSubjectList().get(i);

                    } else {
                        System.out.println("Please enter correct index.");
                    }

                    System.out.println("Enter day of week");
                    String day = sc.next().trim().toUpperCase();
                    DayOfWeek dayOfWeek;
                    try {
                        dayOfWeek = DayOfWeek.valueOf(day);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid day. Please try again");
                        break;
                    }

                    System.out.println("Enter time of Lecture");
                    String timeInput = sc.next();
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime time;
                    try {
                        time = LocalTime.parse(timeInput, timeFormatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid time format. Please use hours-minutes.");
                        break;
                    }


                    student.createTimetable(new TimetableEntry(time, dayOfWeek, chooseSubject));
                    break;

                case 4:
                    student.viewTimetable();
                    break;

                case 5:
                    if (student.getSubjectList().size() == 0) {
                        System.out.println("Please add a subject first.");
                        break;
                    } else {
                        student.showSubjects();
                        System.out.println("Enter Subject index");
                        int n = sc.nextInt();
                        if (n >= 0 && n < student.getSubjectList().size()) {
                            Subject choosenSubject = student.getSubjectList().get(n);
                            System.out.print("Enter a date (yyyy-MM-dd): ");
                            String inputDate = sc.next(); //Input is taken in orm of String
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Date in this format
                            LocalDate date;
                            try {
                                date = LocalDate.parse(inputDate, formatter); //Converts String Object into java date object and validates it
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                                break;
                            }
                            System.out.println("Present = true & Absent = false");
                            boolean present = sc.nextBoolean();
                            AttendanceStatus attendanceStatus = new AttendanceStatus(date, choosenSubject, present);
                            student.addAttendanceRecord(attendanceStatus);
                        } else {
                            System.out.println("Please enter a correct index.");
                        }
                    }
                    break;

                case 6:
                    student.viewAttendanceReport();
                    break;

                case 7:
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Number out of Range.");
                    break;
            }
        } while (keepRunning);


    }
}
/*
1. addSubject() bug
2. Add Attendance when no subjects exist
3. Invalid index handling
4. Remove Scanner from Student
5. Improve subject selection UI
6. Improve encapsulation
7. Improve attendance reporting
 */


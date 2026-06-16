import java.util.ArrayList;

public class Student {
    private String name;
    private int rollNumber;
    private String division;
    private String year;
    private ArrayList<Subject> subjectList = new ArrayList<>();
    private ArrayList<TimetableEntry> timetableEntryList = new ArrayList<>();//Each student object has its own timetableEntries(Ex. Monday-10am-Java)
    private ArrayList<AttendanceStatus> attendanceRecordList = new ArrayList<>();//Each student object will have its own attendanceRecord
    // Ex. 10th June - OS - present

    Student(String name, int rollNumber, String division, String year) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.division = division;
        this.year = year;
    }

    public void addSubject(Subject subject) {
        subjectList.add(subject);
        System.out.println(subjectList);
    }

    public void createTimetable(TimetableEntry timetableEntry){
        timetableEntryList.add(timetableEntry);
        System.out.println(timetableEntryList);
    }

    public void addAttendanceRecord(AttendanceStatus attendanceStatus){
        attendanceRecordList.add(attendanceStatus);
        System.out.println(attendanceRecordList);
    }

    public void viewAttendanceReport(Subject subject){
        double subjectLectureOccur = 0;
        double subjectLecturePresent = 0;
        for(AttendanceStatus status : attendanceRecordList){
            if(status.getSubject() == subject){
                subjectLectureOccur++;
            }
            if(status.getSubject()==subject &&  status.isPresent() == true){
                subjectLecturePresent++;
            }
        }

        double subjectAttendance = (subjectLecturePresent/subjectLectureOccur)*100;
        System.out.println(subjectAttendance);

    }
}
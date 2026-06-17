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

    public double calculateAttendanceEachSubject(Subject subject){
        double subjectLectureOccur = 0;
        double subjectLecturePresent = 0;
        double subjectAttendance = 0;
        for(AttendanceStatus status : attendanceRecordList){
            if(status.getSubject().equals(subject)){
                subjectLectureOccur++;
            }
            if(status.getSubject().equals(subject) &&  status.isPresent()){
                subjectLecturePresent++;
            }
        }
        if(subjectLectureOccur==0){
            System.out.println(subject + ": No attendance records available.");
        }
        else {
            subjectAttendance = (subjectLecturePresent/subjectLectureOccur)*100;
        }
        return subjectAttendance;
    }

    public void viewAttendanceReport(){
        double subjectAttendance = 0;

        for(Subject subject : subjectList){
             subjectAttendance = calculateAttendanceEachSubject(subject);
             System.out.println(subject + ": " + subjectAttendance);
        }

        double overallLectureOccur = 0;
        double overallLecturePresent = 0;
        for(AttendanceStatus  status : attendanceRecordList){
                overallLectureOccur++;
            if(status.isPresent()){
                overallLecturePresent++;
            }
        }
        if(overallLectureOccur==0){
            System.out.println("No attendance Report available.");
        }
        else{
            double totalAttendance = (overallLecturePresent/overallLectureOccur)*100;
            System.out.println(totalAttendance);
        }
    }
}
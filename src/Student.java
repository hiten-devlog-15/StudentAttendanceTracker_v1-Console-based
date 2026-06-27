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


    public ArrayList<Subject> getSubjectList(){
        return subjectList;
    }

    public void showSubjects(){
        for(int i = 0; i<subjectList.size(); i++){
            System.out.println(i + ": " +subjectList.get(i));
        }
    }


    Student(String name, int rollNumber, String division, String year) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.division = division;
        this.year = year;
    }

    public void addSubject(Subject subject) {
        boolean duplicateFound = false;
        for(Subject eachSubject : subjectList){
            if(eachSubject.getName().toUpperCase().equals(subject.getName().toUpperCase())){
                duplicateFound = true;
                System.out.println("This subject is already added.");
                break;
            }
        }
        if(!duplicateFound){
            subjectList.add(subject);

        }
    }

    public void viewSubjects(){
        System.out.println(subjectList);
    }

    public void createTimetable(TimetableEntry timetableEntry){
        timetableEntryList.add(timetableEntry);
    }

    public void addAttendanceRecord(AttendanceStatus    attendanceStatus){
        attendanceRecordList.add(attendanceStatus);
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
            subjectAttendance = -1;
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
             if(subjectAttendance == -1){
                 System.out.println(subject + ": No Lectures Occured");
             }
             else {
                 System.out.println(subject + ": " + subjectAttendance);
             }
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
            System.out.println("Overall Attendance: " + totalAttendance);
        }
    }
}
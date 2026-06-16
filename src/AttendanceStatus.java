import java.time.LocalDate;

public class AttendanceStatus {
    private String date;//LocalDate class is highly used in modern days
    private Subject subject;//AttendanceStatus should contain the complete Subject(object) rather than String name of subject
    private boolean present;//This is enough bcoz if true then student is present and if false then student is absent

    AttendanceStatus(String date, Subject subject, boolean present){
        this.date=date;
        this.subject=subject;
        this.present=present;
    }


    public Subject getSubject() {
        return subject;
    }

    public boolean isPresent() {
        return present;
    }
}

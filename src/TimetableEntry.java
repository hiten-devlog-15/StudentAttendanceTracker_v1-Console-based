import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimetableEntry {
    private String time;
    private String dayOfWeek;
    private Subject subject;

    TimetableEntry(String time, String dayOfWeek, Subject subject){
        this.time=time;
        this.dayOfWeek=dayOfWeek;
        this.subject=subject;
    }
}

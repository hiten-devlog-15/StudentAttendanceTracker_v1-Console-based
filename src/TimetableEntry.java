import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimetableEntry {
    private LocalTime time;
    private DayOfWeek dayOfWeek;
    private Subject subject;

    TimetableEntry(LocalTime time, DayOfWeek dayOfWeek, Subject subject){
        this.time=time;
        this.dayOfWeek=dayOfWeek;
        this.subject=subject;
    }

    public LocalTime getTime() {
        return time;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Subject getSubject() {
        return subject;
    }
}

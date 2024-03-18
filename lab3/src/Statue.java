import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

class Statue extends Attraction implements Visitable {
    private Map<LocalDate, TimeInterval> visitingTimetable;

    public Statue(String name) {
        super(name);
        this.visitingTimetable = new HashMap<>();
        // Default timetable for demonstration purposes
        this.visitingTimetable.put(LocalDate.of(2024, 3, 8), new TimeInterval(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        this.visitingTimetable.put(LocalDate.of(2024, 3, 9), new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));
    }

    @Override
    public Map<LocalDate, TimeInterval> getVisitingTimetable() {
        return visitingTimetable;
    }
}
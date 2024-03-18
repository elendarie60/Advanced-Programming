import java.time.*;
import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Map;

public interface Visitable {

    Map<LocalDate, TimeInterval> getVisitingTimetable();

    default LocalTime getOpeningHour(LocalDate date) {
        Map<LocalDate, TimeInterval> timetable = getVisitingTimetable();
        return timetable.containsKey(date) ? timetable.get(date).getStart() : null;
    }

    default String getName() {
        return ""; // empty string
    }

}

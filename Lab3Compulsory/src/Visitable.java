import java.time.DayOfWeek;
import java.util.*;

interface Visitable {
    Set<DayOfWeek> getOpenDays();
    Map<DayOfWeek, String> getOpeningHours();
}

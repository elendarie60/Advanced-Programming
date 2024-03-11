import java.time.DayOfWeek;
import java.util.*;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

class Statue extends Attraction implements Visitable {
    private Set<DayOfWeek> openDays;
    private Map<DayOfWeek, String> openingHours;

    public Statue(String name, Set<DayOfWeek> openDays, Map<DayOfWeek, String> openingHours) {
        super(name);
        this.openDays = openDays;
        this.openingHours = openingHours;
    }

    public Set<DayOfWeek> getOpenDays() {
        return openDays;
    }

    public Map<DayOfWeek, String> getOpeningHours() {
        return openingHours;
    }
}

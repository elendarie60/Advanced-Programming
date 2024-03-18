import java.time.*;
import java.util.*;

class Concert extends Attraction implements Visitable, Payable {

    private Map<LocalDate, TimeInterval> visitingTimetable;
    private double entryFee;

    public Concert(String name, double entryFee) {
        super(name);
        this.entryFee = entryFee;
        this.visitingTimetable = new HashMap<>();
        // Default timetable for demonstration purposes
        this.visitingTimetable.put(LocalDate.of(2024, 3, 8), new TimeInterval(LocalTime.of(20, 0), LocalTime.of(23, 0)));
        this.visitingTimetable.put(LocalDate.of(2024, 3, 9), new TimeInterval(LocalTime.of(21, 0), LocalTime.of(23, 30)));
    }

    @Override
    public Map<LocalDate, TimeInterval> getVisitingTimetable() {
        return visitingTimetable;
    }

    @Override
    public double getEntryFee() {
        return entryFee;
    }
}

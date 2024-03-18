import java.time.*;
import java.util.*;

class Church extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> visitingTimetable;
    private double entryFee;

    public Church(String name, double entryFee) {
        super(name);
        this.entryFee = entryFee;
        this.visitingTimetable = new HashMap<>();
        // Default timetable for demonstration purposes
        this.visitingTimetable.put(LocalDate.of(2024, 3, 8), new TimeInterval(LocalTime.of(8, 0), LocalTime.of(18, 0)));
        this.visitingTimetable.put(LocalDate.of(2024, 3, 9), new TimeInterval(LocalTime.of(9, 0), LocalTime.of(17, 0)));
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
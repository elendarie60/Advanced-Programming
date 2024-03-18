import java.time.*;
import java.util.*;
import java.util.Map;
import java.time.LocalDate;

class TravelPlan {
    private Map<LocalDate, Attraction> plan;

    public TravelPlan() {
        this.plan = new HashMap<>();
    }

    public void addVisit(LocalDate date, Attraction attraction) {
        plan.put(date, attraction);
    }

    public void printPlan() {
        System.out.println("Travel Plan:");
        for (Map.Entry<LocalDate, Attraction> entry : plan.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
    }
}
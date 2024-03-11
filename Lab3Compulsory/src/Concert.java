import java.util.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

class Concert extends Attraction implements Visitable,Payable {
       private Set<DayOfWeek> openDays;
       private Map<DayOfWeek, String> openingHours;
       private double entryFee;

       public Concert(String name, Set<DayOfWeek> openDays, Map<DayOfWeek, String> openingHours, double entryFee) {
              super(name);
              this.openDays = openDays;
              this.openingHours = openingHours;
              this.entryFee = entryFee;
       }

       public Set<DayOfWeek> getOpenDays() {
              return openDays;
       }

       public Map<DayOfWeek, String> getOpeningHours() {
              return openingHours;
       }

       public double getEntryFee() {
              return entryFee;
       }
}

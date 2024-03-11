import java.time.DayOfWeek;
import java.util.*;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

abstract class Attraction implements Comparable<Attraction> {
    protected String name;

    public Attraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

        public int compareTo(Attraction a){
            return this.name.compareTo(a.name);
        }
    }
}

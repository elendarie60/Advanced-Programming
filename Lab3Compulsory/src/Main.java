import javax.xml.namespace.QName;
import java.time.DayOfWeek;
import java.util.*;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Trip trip = new Trip("CityName", new Date(), new Date());

        trip.addAttraction(statue);
        trip.addAttraction(church);
        trip.addAttraction(concert);

        Statue statue = new Statue("Statue of Liberty",
                new HashSet<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY)),
                Collections.singletonMap(DayOfWeek.MONDAY, "9:00 AM - 6:00 PM"));

        Church church = new Church(name:);



        System.out.println("Trip to: " + trip.getCityName());
        System.out.println("Start Date: " + trip.getStartDate());
        System.out.println("End Date: " + trip.getEndDate());
        System.out.println("Attractions:");
        for (Attraction attraction : trip.getAttractions()) {
            System.out.println(attraction.getName());
        }
    }
}
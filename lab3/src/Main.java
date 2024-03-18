import java.time.*;
import java.util.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create a trip
        Trip trip = new Trip("CityName", LocalDate.of(2024, 3, 8), LocalDate.of(2024, 3, 10));

        // Create attractions
        Statue statue = new Statue("Statue of Liberty");
        Church church = new Church("St. Peter's Basilica", 10.0);
        Concert concert = new Concert("Rock Concert", 20.0);

        // Add attractions to the trip
        trip.addAttraction(statue);
        trip.addAttraction(church);
        trip.addAttraction(concert);

        // Display visitable and non-payable attractions sorted by opening hour
        List<Visitable> visitableLocations = trip.getVisitableLocations();
        System.out.println("Visitable Locations (Not Payable):");
        for (Visitable location : visitableLocations) {
            System.out.println(location.getName() + " - Opening Hour: " + location.getOpeningHour(trip.getStartDate()));
        }

        // Create a travel plan
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addVisit(LocalDate.of(2024, 3, 8), statue);
        travelPlan.addVisit(LocalDate.of(2024, 3, 8), church);
        travelPlan.addVisit(LocalDate.of(2024, 3, 9), concert);

        // Print the travel plan
        travelPlan.printPlan();
    }
}
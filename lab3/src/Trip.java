import java.time.*;
import java.util.*;
import java.time.LocalDate;

class Trip {
    private String cityName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Attraction> attractions;

    public Trip(String cityName, LocalDate startDate, LocalDate endDate) {
        this.cityName = cityName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attractions = new ArrayList<>();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Visitable> getVisitableLocations() {
        List<Visitable> visitableLocations = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableLocations.add((Visitable) attraction);
            }
        }
        visitableLocations.sort(Comparator.comparing(v -> v.getOpeningHour(startDate)));
        return visitableLocations;
    }
}

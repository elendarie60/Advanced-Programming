import java.time.DayOfWeek;
import java.util.*;
import java.util.Map;
import java.util.Set;

class Trip {
    private String cityName;
    private Date startDate;
    private Date endDate;
    private List<Attraction> attractions;

    public Trip(String cityName, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }
}

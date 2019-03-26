package mw.forwardplay.mdima.entities;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class Schedules {
    private String name;
    private int duration;
    private String startingDate;
    private String endingDate;
    private String group;
    private List<String> regions;
    private List<String> locations;
    private List<String> areas;

    public Schedules()
    {

    }

    public Schedules(String name, int duration, String startingDate, String endingDate,
                     List<String>locations, List<String> regions, List<String> areas, String group)
    {
        this.name = name;
        this.duration = duration;
        this.endingDate = endingDate;
        this.startingDate = startingDate;
        this.group = group;
        this.areas = areas;
        this.locations = locations;
        this.regions = regions;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegions() {
        return regions;
    }

    public List<String> getLocations() {
        return locations;
    }

    public List<String> getAreas() {
        return areas;
    }

    public String getGroup() {
        return group;
    }


    public String getEndingDate() {
        return endingDate;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }
}

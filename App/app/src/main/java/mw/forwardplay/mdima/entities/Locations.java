package mw.forwardplay.mdima.entities;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;
@IgnoreExtraProperties
public class Locations {
    private String location;
    private String region;
    private List<String> areas;
    private List<String> groups;

    public Locations() {}
    public Locations(String location, String region, List<String> areas, List<String>groups){
        this.location = location;
        this.region = region;
        this.areas = areas;
        this.groups = groups;
    }

    public String getRegion() {
        return region;
    }

    public List<String> getGroups() {
        return groups;
    }

    public List<String> getAreas() {
        return areas;
    }

    public String getLocation() {
        return location;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package mw.forwardplay.mdima.entities;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;
@IgnoreExtraProperties
public class Groups {
    private String group;
    private List<String> areas;
    private List<String> regions;
    private List<String> locations;

    public Groups(){}
    public Groups(String group, List<String> areas, List<String> locations, List<String> regions)
    {
        this.group = group;
        this.areas = areas;
        this.locations = locations;

    }

    public List<String> getAreas() {
        return areas;
    }

    public List<String> getLocations() {
        return locations;
    }

    public List<String> getRegions() {
        return regions;
    }

    public String getGroup() {
        return group;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }
}


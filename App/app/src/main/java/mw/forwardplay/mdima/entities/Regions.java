package mw.forwardplay.mdima.entities;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class Regions {

    private String region;
    private List<String> locations;
    private List<String> groups;

    public void Regions()
    {

    }

    public void Regions(String region, List<String> locations, List<String> groups)
    {
        this.region = region;
        this.locations = locations;
        this.groups = groups;
    }

    public List<String> getGroups() {
        return groups;
    }

    public List<String> getLocations() {
        return locations;
    }

    public String getRegion() {
        return region;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

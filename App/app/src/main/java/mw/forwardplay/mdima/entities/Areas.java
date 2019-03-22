package mw.forwardplay.mdima.entities;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;
@IgnoreExtraProperties
public class Areas {
    private String area;
    private String location;
    private String region;
    private List<String> groups;

    public Areas(){}
    public Areas(String area, String location, String region, List<String> groups)
    {
        this.area = area;
        this.location = location;
        this.region = region;
        this.groups = groups;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getGroups() {
        return groups;
    }

    public String getRegion() {
        return region;
    }

    public String getArea() {
        return area;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setArea(String area) {
        this.area = area;
    }
}


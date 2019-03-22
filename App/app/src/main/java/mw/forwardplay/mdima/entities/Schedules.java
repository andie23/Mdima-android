package mw.forwardplay.mdima.entities;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Schedules {
    private String name;
    private String duration;
    private String startingDate;
    private String endingDate;
    private String group;

    public Schedules()
    {

    }

    public Schedules(String name, String duration, String startingDate, String endingDate, String group)
    {
        this.duration = duration;
        this.endingDate = endingDate;
        this.startingDate = startingDate;
        this.group = group;
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public String getDuration() {
        return duration;
    }
}

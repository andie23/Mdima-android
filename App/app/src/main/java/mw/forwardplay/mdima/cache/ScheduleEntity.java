package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "schedules")
public class ScheduleEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "date")
    private long date;
    @ColumnInfo(name = "starting_time")
    private long startingTime;
    @ColumnInfo(name = "finish_time")
    private long finishTime;
    @ColumnInfo(name = "duration")
    private int duration;
    @ColumnInfo(name = "group_name")
    private String groupName;

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getGroupName() {
        return groupName;
    }

    public long getDate() {
        return date;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public long getStartingTime() {
        return startingTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setStartingTime(long startingTime) {
        this.startingTime = startingTime;
    }
}

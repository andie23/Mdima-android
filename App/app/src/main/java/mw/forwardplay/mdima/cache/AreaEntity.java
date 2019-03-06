package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "areas")
public class AreaEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "location_id")
    private int locationId;
    @ColumnInfo(name = "name")
    private String name;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}

package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "locations")
public class LocationEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "region_id")
    private int regionId;
    @ColumnInfo(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public int getRegionId()
    {
        return regionId;
    }

    public String getName() {
        return name;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package mw.forwardplay.mdima.adapters;

import java.util.HashMap;
import java.util.Map;

public class ListData{
    private String id;
    private String title;
    private String description;
    public Map<String, String> params = new HashMap<>();

    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getTitle() { return title; }
    public void setDescription(String description) { this.description = description; }
    public void setTitle(String title) { this.title = title; }
    public void setId(String id) { this.id = id; }
}
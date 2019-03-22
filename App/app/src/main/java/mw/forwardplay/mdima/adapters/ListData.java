package mw.forwardplay.mdima.adapters;

public class ListData{
    private String id;
    private String title;
    private String description;

    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getTitle() { return title; }
    public void setDescription(String description) { this.description = description; }
    public void setTitle(String title) { this.title = title; }
    public void setId(String id) { this.id = id; }
}
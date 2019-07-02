package model;

import java.util.HashSet;

public class Newsletter {
    private String title;
    private String contents;

    private HashSet<String> tags;

    //Constructors
    public Newsletter(String title, String contents, HashSet<String> tags){
        this.title = title;
        this.contents = contents;
        this.tags = tags;
    }

    public Newsletter(){
        this("Newsletter Title", "Newsletter Contents", new HashSet<>());
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    //Public Methods
    public void addTag(String tag){
        tags.add(tag);
    }

    public void removeTag(String tag){
        if (tags.contains(tag))
            tags.remove(tag);
    }
}

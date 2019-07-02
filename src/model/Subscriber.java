package model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {
    private String name;
    private HashSet<String> tags;
    private HashSet<String> followedNewsletters;

    //Constructors
    public Subscriber(String name, HashSet<String> tags){
        this.name = name;
        this.tags = tags;
        followedNewsletters = new HashSet<String>();
    }

    public Subscriber(String name){
        this(name, new HashSet<String>());
    }

    //Getters and Setters


    public String getName() {
        return name;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public HashSet<String> getFollowedNewsletters() {
        return followedNewsletters;
    }

    //Public Methods
    @Override
    public void update(Observable o, Object arg) {
        HashSet<String> newsletterTags = ((Newsletter)arg).getTags();
        for(String newsletterTag: newsletterTags){
            if (tags.contains(newsletterTag)){
                followedNewsletters.add(((Newsletter)arg).getTitle());
                break;
            }
        }
    }

    public void readAllNewsletters(){
        System.out.println("Subscriber Name: " + name);
        System.out.println("Followed Tabs: ");
        for(String tag: tags){
            System.out.println("\t" + tag);
        }
        System.out.println("Newsletters Recieved: ");
        for(String newsletter: followedNewsletters){
            System.out.println("\t" + newsletter);
        }
        System.out.println();
    }
}

package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;


public class Publisher extends Observable{
    private List<Newsletter> newsletterList;

    //Constructors
    public Publisher(){
        newsletterList = new ArrayList<Newsletter>();
    }

    //Getters and Setters
    public List<Newsletter> getNewsletterList() {
        return newsletterList;
    }

    //Public Methods
    public void publishNewsletter(String title, String contents, HashSet<String> tags){
        Newsletter newsletter = new Newsletter(title, contents, tags);
        newsletterList.add(newsletter);
        setChanged();
    }

    public void publishNewsletter(Newsletter newsletter){
        newsletterList.add(newsletter);
        setChanged();
    }

    public void notifySubscribersOfLatestNewsletter(){
        notifyObservers(newsletterList.get(newsletterList.size() - 1));
    }

}

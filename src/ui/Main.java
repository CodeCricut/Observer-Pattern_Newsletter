package ui;

import model.Newsletter;
import model.Publisher;
import model.Subscriber;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    private static Publisher publisher;
    private static HashSet<Subscriber> subscribers;

    public static void main(String[] args) {
        initializePublisher();
        initializeSubscribers();
        printAllSubscriberInformation();
        publishNewsletters();
        printAllSubscriberInformation();
    }

    private static void initializePublisher(){
        System.out.println("Starting up publishing company...");
        publisher = new Publisher();
    }

    private static void initializeSubscribers() {
        System.out.println("Advertising to Subscribers...");
        subscribers = new HashSet<>();

        HashSet<String> boringTags = new HashSet<>();
        boringTags.add("Home");
        Subscriber boringSub = new Subscriber("Jorge", boringTags);
        subscribers.add(boringSub);
        publisher.addObserver(boringSub);

        HashSet<String> moderateTags = new HashSet<>();
        moderateTags.add("Fun");
        moderateTags.add("Cooking");
        Subscriber moderateSub = new Subscriber("Erin", moderateTags);
        subscribers.add(moderateSub);
        publisher.addObserver(moderateSub);

        HashSet<String> coolTags = new HashSet<>();
        coolTags.add("Fun");
        coolTags.add("Thrill");
        Subscriber coolSub = new Subscriber("Jesse", coolTags);
        subscribers.add(coolSub);
        publisher.addObserver(coolSub);
    }

    private static void publishNewsletters(){ //need to tack newsletters to publisher and also notify subs
        System.out.println("Publishing newsletters...");

        HashSet<String> ramenTags = new HashSet<>();
        ramenTags.add("Cooking");
        ramenTags.add("Home");
        Newsletter ramenNewsletter = new Newsletter("How to Make Ramen",
                "First, you must cook the ramen. Next, you eat the ramen.", ramenTags);
        printNewsletterInformation(ramenNewsletter);
        publisher.publishNewsletter(ramenNewsletter);
        publisher.notifySubscribersOfLatestNewsletter();

        HashSet<String> skydivingTags = new HashSet<>();
        skydivingTags.add("Thrill");
        skydivingTags.add("Fun");
        Newsletter skydivingNewsletter = new Newsletter("Skydiving: Fun or Deadly?",
                "It's pretty fun, I guess, but it also kinda deadly too... I can't make up my mind, you decide.", skydivingTags);
        printNewsletterInformation(skydivingNewsletter);
        publisher.publishNewsletter(skydivingNewsletter);
        publisher.notifySubscribersOfLatestNewsletter();

    }

    private static void printNewsletterInformation(Newsletter newsletter) {
        System.out.println("\tTitle: " + newsletter.getTitle());
        System.out.println("\tTags: " + newsletter.getTags().toString());
        System.out.println();
    }

    private static void printAllSubscriberInformation(){
        System.out.println("Subscribers:");
        for (Subscriber sub: subscribers) {
            System.out.println("\tSub Name: " + sub.getName());
            System.out.println("\tSub Interests: " + sub.getTags());
            System.out.println("\tSub newletters: " + sub.getFollowedNewsletters());
            System.out.println();
        }
    }


}

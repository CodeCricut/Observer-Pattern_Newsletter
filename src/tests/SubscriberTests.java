package tests;

import model.Publisher;
import model.Subscriber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriberTests {
    @BeforeAll
    static void setup(){

    }

    @Test
    public void testDefaultConstructor(){
        Subscriber sub = new Subscriber("Bob");
        assertTrue(sub.getTags().isEmpty());
    }

    @Test
    public void testExplicitConstructor(){
        HashSet<String> tags = new HashSet<String>();
        tags.add("Tag 1");
        tags.add("Tag 2");

        Subscriber sub = new Subscriber("Bob", tags);
        assertTrue(sub.getTags().size() == 2);
    }

    @Test
    public void testUpdateWithCorrectTags(){
        Publisher pub = new Publisher();

        HashSet<String> subFollowedTags = new HashSet<>();
        subFollowedTags.add("Followed tag 1");
        Subscriber sub = new Subscriber("Bob", subFollowedTags);
        pub.addObserver(sub);
        assertTrue(sub.getFollowedNewsletters().isEmpty());

        pub.publishNewsletter("Title", "Contents", subFollowedTags);
        pub.notifySubscribersOfLatestNewsletter();
        assertTrue(sub.getFollowedNewsletters().size() == 1);

    }

    @Test
    public void testUpdateWithoutCorrectTags(){
        Publisher pub = new Publisher();

        HashSet<String> subFollowedTags = new HashSet<>();
        subFollowedTags.add("Followed tag 1");
        Subscriber sub = new Subscriber("Bob", subFollowedTags);
        pub.addObserver(sub);
        assertTrue(sub.getFollowedNewsletters().isEmpty());

        HashSet<String> wrongNewsletterTags = new HashSet<>();
        wrongNewsletterTags.add("Wrong tag 1");

        pub.publishNewsletter("Title", "Contents", wrongNewsletterTags);
        pub.notifySubscribersOfLatestNewsletter();
        assertTrue(sub.getFollowedNewsletters().isEmpty());
    }
}

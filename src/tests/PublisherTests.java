package tests;

import model.Newsletter;
import model.Publisher;
import model.Subscriber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PublisherTests {
    private Publisher publisher;
    private HashSet<String> sampleTags;

    @BeforeEach
    public void iniPublisher(){
        publisher = new Publisher();
        sampleTags = new HashSet<>();
        sampleTags.add("Tag 1");
        sampleTags.add("Tag 2");
    }

    @Test
    public void testExplicitAddNewsletter(){
        assertTrue(publisher.getNewsletterList().isEmpty());
        publisher.publishNewsletter("New newsletter", "newsletter contents", sampleTags);

        assertTrue(publisher.getNewsletterList().size() == 1);
    }

    @Test
    public void testAddNewsletter(){
        assertTrue(publisher.getNewsletterList().isEmpty());
        Newsletter newsletter = new Newsletter("New newsletter", "newsletter contents", sampleTags);
        publisher.publishNewsletter(newsletter);

        assertTrue(publisher.getNewsletterList().size() == 1);
    }

    @Test
    public void testObserver(){
        Subscriber sub = new Subscriber("Bob", sampleTags);
        assertTrue(publisher.countObservers() == 0);
        assertTrue(sub.getFollowedNewsletters().isEmpty());

        publisher.addObserver(sub);
        assertTrue(publisher.countObservers() == 1);

        Newsletter newsletter = new Newsletter("New newsletter", "newsletter contents", sampleTags);
        publisher.publishNewsletter(newsletter);
        publisher.notifySubscribersOfLatestNewsletter();
        assertTrue(sub.getFollowedNewsletters().size() == 1);
        assertTrue(sub.getFollowedNewsletters().contains("New newsletter"));
    }
}















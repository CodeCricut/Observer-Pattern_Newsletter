package tests;

import model.Newsletter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class NewsletterTests {
    @BeforeAll
    static void setUp(){

    }

    @BeforeEach
    public void reset(){

    }

    @Test
    public void testExplicitConstructor(){
        HashSet<String> tags = new HashSet<String>();
        tags.add("Sample tag");

        Newsletter newsletter = new Newsletter("Newsletter 1", "This is an explicit constructor", tags);
        assertTrue("Newsletter 1".equals(newsletter.getTitle()));
        assertTrue("This is an explicit constructor".equals(newsletter.getContents()));
        assertTrue(newsletter.getTags().contains("Sample tag"));
    }

    @Test
    public void testDefaultConstructor(){
        Newsletter newsletter = new Newsletter();
        assertTrue("Newsletter Title".equals(newsletter.getTitle()));
        assertTrue("Newsletter Contents".equals(newsletter.getContents()));
        assertTrue(newsletter.getTags().isEmpty());
    }

    @Test
    public void testGettersAndSetters(){
        Newsletter newsletter = new Newsletter();
        assertTrue("Newsletter Title".equals(newsletter.getTitle()));
        assertTrue("Newsletter Contents".equals(newsletter.getContents()));
        assertTrue(newsletter.getTags().isEmpty());

        HashSet<String> tags = new HashSet<>();
        tags.add("tag 1");
        tags.add("tag 2");

        newsletter.setTitle("New Title");
        newsletter.setContents(("New Contents"));
        newsletter.setTags(tags);
        assertTrue("New Title".equals(newsletter.getTitle()));
        assertTrue("New Contents".equals(newsletter.getContents()));
        assertTrue(tags.equals(newsletter.getTags()));
    }

    @Test
    public void testTagAddersRemovers(){
        Newsletter newsletter = new Newsletter();
        assertTrue(newsletter.getTags().isEmpty());

        newsletter.addTag("Added tag 1");
        assertTrue(newsletter.getTags().size() == 1);

        newsletter.removeTag("Added tag 1");
        assertTrue(newsletter.getTags().size() == 0);

        newsletter.addTag("Added tag 2");
        assertTrue(newsletter.getTags().size() == 1);

        newsletter.removeTag("Wrong tag");
        assertTrue(newsletter.getTags().size() == 1);
    }
}

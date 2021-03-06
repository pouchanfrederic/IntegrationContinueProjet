package chatProject.model.messages;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void getId() {
        int id = 42;
        final Message<Object> message = new Message<>(null, null);

        assertEquals(id, message.getId());
    }

    @Test
    public void getContent() {
        String content = "TEST";
        final Message<String> message = new Message<>(null, content);

        assertEquals("The message content is not the one set in the constructor",
                content, message.getMessage());
    }

}
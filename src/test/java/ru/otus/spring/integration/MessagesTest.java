package ru.otus.spring.integration;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SuppressWarnings("all")
@Ignore
public class MessagesTest {

    @Test
    public void testCreateSimpleGenericMessage() {
        // TODO: create message with the "Hello" payload
        Message<String> message = null;

        assertNotNull(message);
        assertNotNull(message.getPayload());
        assertEquals("Hello", message.getPayload());
    }

    @Test
    public void testCreateGenericMessage() {
        // TODO: create message with the User payload
        Message<User> message = null;

        assertNotNull(message);
        assertNotNull(message.getPayload());
        assertEquals(new User("John", 23), message.getPayload());
    }

    @Test
    public void testGenericMessageWithHeaders() {
        // TODO: create message with the "Hello" payload, and "to" header
        Map<String, Object> headers = null;
        Message<String> message = null;

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testGenericMessageWithMessageHeaders() {
        // TODO: create message with the payload and MessageHeaders
        MessageHeaders headers = null;
        Message<String> message = null;

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testErrorMessage() {
        // TODO: create error message with the NullPointerException object
        Message errorMessage = null;

        assertNotNull(errorMessage);
        assertEquals(ErrorMessage.class, errorMessage.getClass());
        assertEquals(NullPointerException.class, errorMessage.getPayload().getClass());
    }

    @Test
    public void testMessageBuilder() {
        // TODO: create message with "Hello" payload and "to":"World" header using MessageBuilder
        Message message = null;

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testBuildFromMessage() {
        Message<User> original = MessageBuilder
            .withPayload(new User("Kate", 30))
            .setHeader("processor", "userService")
            .build();

        // TODO: create message with the same headers and payload using MessageBuilder
        Message<User> newMessage = null;

        assertNotNull(newMessage);
        assertEquals(original.getPayload(), newMessage.getPayload());
        assertEquals(original.getHeaders().get("processor"), newMessage.getHeaders().get("processor"));
    }
}

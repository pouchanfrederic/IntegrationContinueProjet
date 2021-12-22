package chatProject.model.messages;
import chatProject.model.FakeInstances;
import chatProject.model.user.Status;
import chatProject.model.user.UserAccount;
import chatProject.model.user.UserInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ChatroomTest {

    @Test
    public void getOwner() {
        Chatroom chatroomTest = new Chatroom("testName", FakeInstances.DUMMY_ACTIVE_USER, null);

        assertEquals(FakeInstances.DUMMY_ACTIVE_USER, chatroomTest.getOwner());
    }

    @Test
    public void getCurrentMessages() {
        Chatroom chatroomTest = new Chatroom("testName", FakeInstances.DUMMY_ACTIVE_USER, new ArrayList<>(
                asList(FakeInstances.DUMMY_MESSAGE_1)));

        assertEquals(new ArrayList<>(asList(FakeInstances.DUMMY_MESSAGE_1)), chatroomTest.getCurrentMessages());
    }

    @Test
    public void addMessage() {
        Chatroom chatroomTest = new Chatroom("testName", FakeInstances.DUMMY_ACTIVE_USER, new ArrayList<>(
                asList(FakeInstances.DUMMY_MESSAGE_1)));

        int sizeBefore = chatroomTest.getCurrentMessages().size();

        chatroomTest.addMessage(FakeInstances.DUMMY_ACTIVE_USER, FakeInstances.DUMMY_MESSAGE_1);

        int sizeAfter = chatroomTest.getCurrentMessages().size();

        assertEquals(sizeBefore +1, sizeAfter);
    }

    @Test
    public void addMessageTwo() {
        Chatroom chatroomTest = new Chatroom("testName", FakeInstances.DUMMY_ACTIVE_USER, new ArrayList<>(
                asList(FakeInstances.DUMMY_MESSAGE_1)));

        int sizeBefore = chatroomTest.getCurrentMessages().size();

        chatroomTest.addMessage(new Message<Object>(FakeInstances.DUMMY_ACTIVE_USER, "Coucou"));

        int sizeAfter = chatroomTest.getCurrentMessages().size();

        assertEquals(sizeBefore +1, sizeAfter);
    }



}

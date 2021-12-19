package chatProject.model.messages;

import chatProject.model.FakeInstances;
import chatProject.model.user.UserInfo;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ChatInstanceTest {

    @Test
    public void getCurentChatrooms() {
        ChatInstance chatInstanceTest = FakeInstances.DUMMY_CHAT_INSTANCE;

        int sizeBefore = chatInstanceTest.getCurentChatrooms().size();
        chatInstanceTest.addChatroom(FakeInstances.DUMMY_CHATROOM_1);
        chatInstanceTest.addChatroom(FakeInstances.DUMMY_CHATROOM_2);
        int sizeAfter = chatInstanceTest.getCurentChatrooms().size();

        assertEquals(sizeBefore + 2, sizeAfter);
    }

    @Test
    public void addUser() {
        ChatInstance chatInstanceTest = FakeInstances.DUMMY_CHAT_INSTANCE;

        UserInfo userInfoTest = FakeInstances.UNKNOWN_USER_INFO;

        assertEquals(chatInstanceTest.addUser(userInfoTest), true);
    }

    @Test
    public void addUserWhenAlreadyCreated() {
        ChatInstance chatInstanceTest = FakeInstances.DUMMY_CHAT_INSTANCE;

        UserInfo userInfoTest = FakeInstances.UNKNOWN_USER_INFO;
        boolean booleanBefore = chatInstanceTest.addUser(userInfoTest);
        boolean booleanAfter = chatInstanceTest.addUser(userInfoTest);

        assertNotEquals(booleanBefore, booleanAfter);
    }

}

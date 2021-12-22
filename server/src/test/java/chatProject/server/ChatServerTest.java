package chatProject.server;

import chatProject.model.messages.ChatInstance;
import chatProject.model.messages.Chatroom;
import chatProject.model.messages.Message;
import chatProject.model.user.Status;
import chatProject.model.user.UserAccount;
import chatProject.model.user.UserInfo;
import chatProject.server.ChatServer;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;


public class ChatServerTest {

    /* Methode test getUsers */
    @Test
    public void getUsers() {
        //Given
        final UserAccount userAccount1 = new UserAccount(3, "User1");
        final UserAccount userAccount2 = new UserAccount(7, "User2");

        final UserInfo activeUser1 = new UserInfo(userAccount1, Status.ACTIVE);
        final UserInfo inactiveUser1 = new UserInfo(userAccount2, Status.INACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
            userMap.put(activeUser1, LocalTime.now());
            userMap.put(inactiveUser1, LocalTime.now());

        final Message<String> message1 =
                new Message<>(activeUser1, "Hello");
        final Message<String> message2 =
                new Message<>(inactiveUser1, "Bye");

        final Chatroom<String> chatroom1 =
                new Chatroom<>(
                        "ROOM 1",
                        activeUser1,
                        new ArrayList<>(asList(message2))
                );
        final Chatroom<String> chatroom2 =
                new Chatroom<>(
                        "ROOM 2",
                        inactiveUser1,
                        new ArrayList<>(asList(message1, message2))
                );


        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom1, chatroom2)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertEquals(chatInstance.getUsers().keySet(), server.getUsers());
    }

    /*
    * Test Method login
    * @Param username = "usernameLoginTest"
    */
    @Test
    public void login() {
        //Given
        String userName = "usernameLoginTest";
        final UserAccount userAccount1 = new UserAccount(3, userName);

        final UserInfo activeUser1 = new UserInfo(userAccount1, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
        userMap.put(activeUser1, LocalTime.now());

        final Message<String> message1 =
                new Message<>(activeUser1, "Hello");

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        "ROOM 1",
                        activeUser1,
                        new ArrayList<>(asList(message1))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertEquals(activeUser1, server.login(userName));
    }

    /*
     * Test Method findUser
     * Avec un utilisateur nommé "usernamefindUserTest"
     */
    @Test
    public void findUserWithUser() {
        //Given
        String userName = "usernamefindUserTest";
        final UserAccount userAccount1 = new UserAccount(3, userName);

        final UserInfo activeUser1 = new UserInfo(userAccount1, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
        userMap.put(activeUser1, LocalTime.now());

        final Message<String> message1 =
                new Message<>(activeUser1, "Hello");

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        "ROOM 1",
                        activeUser1,
                        new ArrayList<>(asList(message1))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertEquals(userAccount1, server.findUser(userName).get());
    }

    /*
     * Test Method findUser
     * Sans utilisateur
     */
    @Test
    public void findUserWithoutUser() {
        //Given
        final UserAccount userAccount1 = new UserAccount(3, "username");
        final UserInfo activeUser1 = new UserInfo(userAccount1, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();

        final Message<String> message1 =
                new Message<>(activeUser1, "Hello");

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        "ROOM 1",
                        activeUser1,
                        new ArrayList<>(asList(message1))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertEquals(Optional.empty(), server.findUser(null));
    }

    /* Test Method getNewAvailableID */
    @Test
    public void getNewAvailableID() {
        //Given
        final UserAccount userAccount1 = new UserAccount(3, "username1");
        final UserAccount userAccount2 = new UserAccount(4, "username2");

        final UserInfo userInfo1 = new UserInfo(userAccount1, Status.ACTIVE);
        final UserInfo userInfo2 = new UserInfo(userAccount2, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
        userMap.put(userInfo1, LocalTime.now());
        userMap.put(userInfo2, LocalTime.now());

        final Message<String> message1 =
                new Message<>(userInfo1, "Hello");

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        "ROOM 1",
                        userInfo1,
                        new ArrayList<>(asList(message1))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertEquals(5, server.getNewAvailableID());
    }

    /* Test Method verifyIfIDExists avec un cas valid */
    @Test
    public void verifyIfIDExistsWithValid() {
        //Given
        final UserAccount userAccount1 = new UserAccount(3, "username1");
        final UserAccount userAccount2 = new UserAccount(4, "username2");

        final UserInfo userInfo1 = new UserInfo(userAccount1, Status.ACTIVE);
        final UserInfo userInfo2 = new UserInfo(userAccount2, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
        userMap.put(userInfo1, LocalTime.now());
        userMap.put(userInfo2, LocalTime.now());

        final Message<String> message1 =
                new Message<>(userInfo1, "Hello");

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        "ROOM 1",
                        userInfo1,
                        new ArrayList<>(asList(message1))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertTrue(server.verifyIfIDExists(5));
    }

    /* Test Method verifyIfIDExists avec un cas non valid */
    @Test
    public void verifyIfIDExistsWithNotValid() {
        //Given
        final UserAccount userAccount1 = new UserAccount(3, "username1");
        final UserAccount userAccount2 = new UserAccount(4, "username2");

        final UserInfo userInfo1 = new UserInfo(userAccount1, Status.ACTIVE);
        final UserInfo userInfo2 = new UserInfo(userAccount2, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
        userMap.put(userInfo1, LocalTime.now());
        userMap.put(userInfo2, LocalTime.now());

        final Message<String> message1 =
                new Message<>(userInfo1, "Hello");

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        "ROOM 1",
                        userInfo1,
                        new ArrayList<>(asList(message1))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertFalse(server.verifyIfIDExists(4));
    }

    /* Test Method getCurrentChatroomNames avec un cas non valid */
    @Test
    public void getCurrentChatroomNames() {
        //Given
        String chatroomName1 = "ChatroomName1";
        String chatroomName2 = "ChatroomName2";

        List<String> listchatroomName = Arrays.asList("ChatroomName1", "ChatroomName2");

        final UserAccount userAccount1 = new UserAccount(3, "username1");
        final UserInfo userInfo1 = new UserInfo(userAccount1, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
        userMap.put(userInfo1, LocalTime.now());

        final Message<String> message1 =
                new Message<>(userInfo1, "Hello");

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        chatroomName1,
                        userInfo1,
                        new ArrayList<>(asList(message1))
                );

        final Chatroom<String> DUMMY_CHATROOM_2 =
                new Chatroom<>(
                        chatroomName2,
                        userInfo1,
                        new ArrayList<>(asList(message1))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom, DUMMY_CHATROOM_2)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertEquals(listchatroomName, server.getCurrentChatroomNames());
    }

    /* Test Method getChatroomMessages */
    @Test
    public void getChatroomMessages() {
        //Given
        final UserAccount userAccount1 = new UserAccount(3, "username1");
        final UserInfo userInfo1 = new UserInfo(userAccount1, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
        userMap.put(userInfo1, LocalTime.now());

        final Message<String> message1 =
                new Message<>(userInfo1, "Hello");
        final Message<String> message2 =
                new Message<>(userInfo1, "Bye");

        List<Message> listMsg = Arrays.asList(message1, message2);

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        "ROOM 1",
                        userInfo1,
                        new ArrayList<>(asList(message1, message2))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom)),
                        userMap
                );

        // When
        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // Then
        assertEquals(listMsg, server.getChatroomMessages(0));
    }


    /* Test Method addChatroom */
    @Test
    public void addChatroom() {
        //Given
        final UserAccount userAccount1 = new UserAccount(3, "username1");
        final UserInfo userInfo1 = new UserInfo(userAccount1, Status.ACTIVE);

        final Map<UserInfo, LocalTime> userMap = new HashMap<>();
        userMap.put(userInfo1, LocalTime.now());

        final Message<String> message1 =
                new Message<>(userInfo1, "Hello");

        final Chatroom<String> chatroom =
                new Chatroom<>(
                        "ROOM 1",
                        userInfo1,
                        new ArrayList<>(asList(message1))
                );

        final ChatInstance<String> chatInstance =
                new ChatInstance<>(
                        new ArrayList<>(asList(chatroom)),
                        userMap
                );

        final ChatServer<String> server = new ChatServer<>(
                chatInstance,
                new HashSet<>(),
                null);

        // When
        server.addChatroom("ROOM 2", userInfo1);

        // Then
        assertEquals(2, server.addChatroom("ROOM 2", userInfo1));
    }




}
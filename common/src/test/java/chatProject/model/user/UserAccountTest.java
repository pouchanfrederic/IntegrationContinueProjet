package chatProject.model.user;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountTest {

    @Test
    public void getUsername() {

        final String username = "My user";
        final UserAccount user = new UserAccount(0, username);

        assertEquals(username, user.getUsername());
    }

    @Test
    public void testEquals() {

        final UserAccount user1 = new UserAccount(1, "MyUser");
        final UserAccount user2 = new UserAccount(2, "MyUser");

        assertEquals(user1.getUsername(), user2.getUsername());
    }

    @Test
    public void testHashCode() {

        final UserAccount user1 = new UserAccount(1, "MyUser");
        final UserAccount user2 = new UserAccount(2, "MyUser");

        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testToString() {

        final UserAccount user = new UserAccount(0, "MyUser");
        assertEquals("MyUser", user.toString());

//        assertEquals("The toString() method of a UserAccount should print the username",
//                "MyUser", user.toString());
    }
}
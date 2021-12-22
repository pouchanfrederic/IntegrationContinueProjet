package chatProject.server;
import org.junit.Test;

import java.io.IOException;

public class MainTest {

    @Test
    public void main() throws IOException {
        String[] args = {"1234", "4567"};
        Main.main(args);
    }

}

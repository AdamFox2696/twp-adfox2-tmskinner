import org.junit.Assert;
import org.junit.Test;

public class WikiConnectionTest {

    @Test
    public void TestConnectToWikipedia() {
        WikiConnection Connection = new WikiConnection();
        String output = Connection.ConnectToWiki("soup");
        Assert.assertNotNull(output);
    }

    @Test
    public void getBarackObamaJson() {
        WikiConnection Connection = new WikiConnection();
        String output = Connection.ConnectToWiki("barack obama");
        Assert.assertNotNull(output);
    }
}

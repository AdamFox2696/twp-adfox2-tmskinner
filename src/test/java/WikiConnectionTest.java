import org.junit.Assert;
import org.junit.Test;

public class WikiConnectionTest {

    @Test
    public void TestConnectToWikipedia() {
        WikiConnection Connection = new WikiConnection();
        boolean output = Connection.ConnectToWiki("soup");
        Assert.assertTrue(output);
    }

    public void getBarackObamaJson() {
        WikiConnection Connection = new WikiConnection();
        boolean output = Connection.ConnectToWiki("barack obama");
        Assert.assertTrue(output);
    }
}

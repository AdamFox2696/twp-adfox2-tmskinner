import org.junit.Assert;
import org.junit.Test;

public class WikiConnectionTest {

    @Test
    public void TestConnectToWikipedia() {
        WikiConnection Connection = new WikiConnection();
        boolean output = Connection.ConnectToWiki("https://en.wikipedia.org");
        Assert.assertTrue(output);
    }
}

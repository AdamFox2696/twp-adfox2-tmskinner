import org.junit.Assert;
import org.junit.Test;

public class WikiConnectionTest {

    @Test
    public void WikiConnectionTest()
    {
        WikiConnection Connection = new WikiConnection();
        boolean output = Connection.ConnectToWiki();
        Assert.assertTrue(output);
    }



}

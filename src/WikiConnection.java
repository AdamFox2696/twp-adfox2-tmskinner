import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WikiConnection {

    public boolean ConnectToWiki()
    {
        try
        {
            URL wiki = new URL("https://en.wikipedia.org");
            HttpURLConnection wikiConnect = (HttpURLConnection) wiki.openConnection();
            Object objData = wikiConnect.getContent();
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }


}

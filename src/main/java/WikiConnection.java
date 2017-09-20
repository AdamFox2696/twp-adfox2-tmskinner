import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WikiConnection {

    public boolean ConnectToWiki(String url){
        String output = "";
        try {
            URL Url = new URL(url);
            HttpURLConnection wikiConnect = (HttpURLConnection) Url.openConnection();
            Object objData = wikiConnect.getContent();
            output = "Connection Successful";
            return true;
        }
        catch(IOException e) {
            output = "Unable to Connect, check your internet connection an try again later.";
            return false;
        }
    }
}

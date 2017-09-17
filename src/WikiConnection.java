import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WikiConnection {


    //public boolean ConnectToWiki()

    public boolean ConnectToWiki()
    {
        try
        {
            URL url = new URL("https://en.wikipedia.org");
            //URL url = new URL("https://en.kgsucfkqlbycxiuhbuykhgvhgftyjghhjgjfbnhj.org");
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            Object objData = urlConnect.getContent();
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
        //System.out.print("It works.");
    }


}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WikiConnection {

    public boolean ConnectToWiki(String request){
        String output = "";
        try {
            String newRequest = formRequest(request);
            String fullUrl = formUrl(newRequest);
            System.out.println(fullUrl);
            URL wikiPage = new URL(fullUrl);
            URLConnection wikiConnect = (HttpURLConnection) wikiPage.openConnection();
            wikiConnect.setRequestProperty("User-Agent","Revision Tracker/0.1 (tms326@bsu.edu)");
            BufferedReader in = new BufferedReader(new InputStreamReader(wikiConnect.getInputStream()));
            String inputLine;
            String meh = "";
            output = "Connection Successful";
            System.out.println(output);
            while ((inputLine = in.readLine()) != null)
                meh = inputLine;
            in.close();
            System.out.println(meh);
            return true;
        }
        catch(IOException e) {
            output = "Unable to Connect, check your internet connection an try again later.";
            return false;
        }
    }

    public String formUrl(String newRequest) {
        String firstHalf = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&list=users&indexpageids=1&titles=";
        String secondHalf = "&rvprop=user%7Ctimestamp&rvlimit=100";
        String fullUrl = firstHalf + newRequest + secondHalf;
        return fullUrl;
    }

    public String formRequest(String request) {
        String[] splitRequest = request.split(" ");
        String newRequest = "";
        for (String words: splitRequest) {
            newRequest += words;
            newRequest += "%20";
            System.out.println(words);
        }
        return newRequest;
    }
}

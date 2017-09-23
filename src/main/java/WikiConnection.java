import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WikiConnection {

    public String ConnectToWiki(String request){
        String output = "";
        //Output is used to tell the user if they have a connection to Wikipedia
        try {
            String newRequest = createRequest(request);
            String fullUrl = createUrl(newRequest);
            URL wikiPage = new URL(fullUrl);
            URLConnection wikiConnect = (HttpURLConnection) wikiPage.openConnection();
            wikiConnect.setRequestProperty("User-Agent","Revision Tracker/0.1 (tms326@bsu.edu)");
            BufferedReader in = new BufferedReader(new InputStreamReader(wikiConnect.getInputStream()));
            String inputLine;
            String JsonData = "";
            output = "Connection Successful";
            System.out.println(output);
            while ((inputLine = in.readLine()) != null)
                JsonData = inputLine;
            //saves the Json to a string for parsing
            in.close();
            System.out.println(JsonData);
            return JsonData;
        }
        catch(IOException e) {
            output = "Unable to Connect, check your internet connection an try again later.";
            return output;
        }
    }

    public String createUrl(String newRequest) {
        //uses Wikipedia API to build a url for JSON data.
        String firstHalf = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&list=users&indexpageids=1&titles=";
        String secondHalf = "&rvprop=user%7Ctimestamp&rvlimit=30";
        String fullUrl = firstHalf + newRequest + secondHalf;
        return fullUrl;
    }

    public String createRequest(String request) {
        //Splits input data and replaces any spaces with a %20 for the link to wikipedia.
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

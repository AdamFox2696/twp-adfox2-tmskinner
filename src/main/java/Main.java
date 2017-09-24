import com.google.gson.JsonArray;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        WikiConnection w = new WikiConnection();
        EditSorter s = new EditSorter();
        Parser p = new Parser();
        String input = w.ConnectToWiki("Soup");
        JsonArray parsedJson = p.parseJson(input);
        HashMap<String, String[]> sortedByTime = p.populateSortedByTime(parsedJson);
        HashMap<String, Integer> usersAndAmounts = p.countRevisions(p.users);
        s.editSort(usersAndAmounts);

    }

}

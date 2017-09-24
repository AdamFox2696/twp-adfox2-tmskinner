import com.google.gson.*;
import java.util.*;

public class Parser {
    HashMap<String,String[]> sortedByTime = new HashMap<String, String[]>();
    HashMap<String, Integer> usersAndAmounts = new HashMap<String, Integer>();
    ArrayList<String> users = new ArrayList<String>();


    public JsonArray parseJson(String input) {
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(input);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject jsonObject = rootObject.getAsJsonObject("query").getAsJsonObject("pages").getAsJsonObject();
        JsonArray array = null;
        for (Map.Entry<String,JsonElement> entry : jsonObject.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }
        return array;
    }

    public HashMap<String, String[]> populateSortedByTime(JsonArray array) {
        int i = 1;
        for (JsonElement item : array) {
            JsonObject userData = item.getAsJsonObject();
            JsonElement Username = userData.get("user");
            JsonElement TimeStamp = userData.get("timestamp");
            String[] j = populateTimeAndPosition(TimeStamp, Integer.toString(i));
            populateUsers(Username);
            sortedByTime.put(Username.getAsString(),j);
            i++;
        }
        return sortedByTime;
    }

    private void populateUsers(JsonElement name) {
        users.add(name.getAsString());
    }

    private String[] populateTimeAndPosition(JsonElement time, String number) {
        String[] timeAndPosition = {time.getAsString(), number};
        return timeAndPosition;
    }

    public HashMap<String, Integer> countRevisions(ArrayList<String> userList) {
        for (String name : userList) {
            int c = 0;
            for (String otherName : userList) {
                if (name.equals(otherName)) {
                    c++;
                }
                usersAndAmounts.put(name,c);
            }
        }
        return usersAndAmounts;
    }
}

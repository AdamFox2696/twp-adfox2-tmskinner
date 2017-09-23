import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Parser {

    public Object parseJson(String input) {
        HashMap<String,String> output = new HashMap<String, String>();
        ArrayList<String> users = new ArrayList<String>();
        ArrayList<String> timeStamps = new ArrayList<String>();
        Set<String> userList = new HashSet<String>();
        JsonParser parser = new JsonParser();
        int counter;
        JsonElement rootElement = parser.parse(input);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject jsonObject = rootObject.getAsJsonObject("query").getAsJsonObject("pages").getAsJsonObject();
        JsonArray array = null;
        for (Map.Entry<String,JsonElement> entry :  jsonObject.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }
        for (JsonElement item : array) {
            JsonObject userData = item.getAsJsonObject();
            JsonElement Username = userData.get("user");
            JsonElement TimeStamp = userData.get("timestamp");
            boolean nameIsInList = false;
            users.add(Username.getAsString());
            timeStamps.add(TimeStamp.getAsString());
            output.put(Username.getAsString(),TimeStamp.getAsString());
        }
        /*userList.addAll(users);
        for (String name : userList) {
            System.out.println(name);
        }*/

        return output;
    }
}

import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Parser {

    public HashMap<String, Integer> parseJson(String input) {
        HashMap<String,String[]> output = new HashMap<String, String[]>();
        HashMap<String, Integer> usersAndAmounts = new HashMap<String, Integer>();
        ArrayList<String> users = new ArrayList<String>();
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(input);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject jsonObject = rootObject.getAsJsonObject("query").getAsJsonObject("pages").getAsJsonObject();
        JsonArray array = null;
        for (Map.Entry<String,JsonElement> entry : jsonObject.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }
        int i = 1;
        for (JsonElement item : array) {
            JsonObject userData = item.getAsJsonObject();
            JsonElement Username = userData.get("user");
            JsonElement TimeStamp = userData.get("timestamp");
            String[] j = {TimeStamp.getAsString(),Integer.toString(i)};
            output.put(Username.getAsString(),j);
            users.add(Username.getAsString());
            i++;
        }
        for (String name : users) {
            int c = 0;
            for (String otherName : users) {
                if (name.equals(otherName)) {
                    c++;
                }
            usersAndAmounts.put(name,c);
            }
        }
        System.out.println(usersAndAmounts);

        return usersAndAmounts;
    }
}

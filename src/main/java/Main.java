import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        WikiConnection w = new WikiConnection();
        EditSorter s = new EditSorter();
        Parser p = new Parser();
        String input = w.ConnectToWiki("Soup");
        HashMap<String, Integer> usersAndAmounts = p.parseJson(input);
        s.editSort(usersAndAmounts);

    }

}

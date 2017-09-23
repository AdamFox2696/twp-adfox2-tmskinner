import java.util.HashMap;
import java.util.Map;

public class EditSorter {

    public HashMap<String, Integer> editSort(HashMap<String, Integer> input) {
        int temp = 0;
        String mostEdits = "";
        if (input.size() != 0) {
            for (Map.Entry<String, Integer> entry : input.entrySet()) {
                if (entry.getValue() > temp) {
                    temp = entry.getValue();
                    mostEdits = entry.getKey();
                }
            }
            System.out.println(mostEdits);
            input.remove(mostEdits);
            return editSort(input);
        }
        return (input);
    }
}

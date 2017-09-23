public class Main {

    public static void main(String[] args) {
        WikiConnection w = new WikiConnection();
        Parser p = new Parser();
        String input = w.ConnectToWiki("Obama");
        p.parseJson(input);
    }

}

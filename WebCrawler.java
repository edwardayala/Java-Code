import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class WebCrawler {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String urlInput = input.nextLine();
        System.out.print("Enter a term to search: ");
        String word = input.nextLine();
        crawler(urlInput, word);
    }

    public static void crawler(String startURL, String word){
        ArrayList<String> pendingURLs = new ArrayList<>();
        ArrayList<String> traversedURLs = new ArrayList<>();
        pendingURLs.add(startURL);
        while (!pendingURLs.isEmpty() && traversedURLs.size() <= 100){
            String urlString = pendingURLs.remove(0);
            if (!traversedURLs.contains(urlString)){
                traversedURLs.add(urlString);
                System.out.println("Craw " + urlString);
                for (String s : getSubURLs(urlString)) {
                    if (!traversedURLs.contains(s))
                        pendingURLs.add(s);
                }
            }
        }
        // Use .split() method from String class to split string into an array based on 'word' - length-1 = occurrences
        System.out.println("\nThe search results for " + word + " are:");
        for (String i : traversedURLs) {
            try{
                URLConnection connection = new URL(i).openConnection();
                Scanner scanner = new Scanner(connection.getInputStream());
                scanner.useDelimiter("\\Z");
                String content = scanner.next();
                System.out.println(word + " occurs " + (content.split(word,-1).length - 1) + " times at " + i);
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static ArrayList<String> getSubURLs(String urlString) {
        ArrayList<String> list = new ArrayList<>();

        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()){
                String line = input.nextLine();
//                System.out.println("-"+line);
                current = line.indexOf("https:",current);
                while (current > 0){
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) {
                        list.add(line.substring(current,endIndex));
                        current = line.indexOf("https:", endIndex);
                    }
                    else {
                        current = -1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
}

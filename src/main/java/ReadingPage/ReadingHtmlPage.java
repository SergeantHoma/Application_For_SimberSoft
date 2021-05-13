package ReadingPage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadingHtmlPage {
    public static void Reading(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String line2 = "";
            int count1 = 0;

            while ((line = reader.readLine()) != null) {
                count1++;
                line2 += line;
            }

            int count3 = 0;

            String[] words = line2.toLowerCase().replaceAll("[-+—.?!)&(,:<>/=_%\\\\\"`«»;@{}'…*$#[0-9]|\\[\\]]", " ").split("\\s");

            System.out.println(words.length + "\n");

            Map<String, Integer> counterMap = new HashMap<>();
            for (String word : words) {
                if (!word.isEmpty()) {
                    Integer count = counterMap.get(word);
                    if (count == null) {
                        count = 0;
                        count3++;
                    }
                    counterMap.put(word, ++count);
                }
            }

            for (String word : counterMap.keySet()) {
                System.out.println(word + ": " + counterMap.get(word));
            }
            System.out.println("Total number of unique words :" + count3);

        }
    }
}

package ifmgbot;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// function to create connection
public class Connect {
    public static String UserAgent = "Mozilla/5.0";
    public static Document doc = null;

    public static Document createConnection(String link) {
        try {
            doc = Jsoup
                    .connect(link)
                    .userAgent(UserAgent)
                    .get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }
}
package ifmgbot;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Connect {
    // function to create connection
    public static Document createConnection() {
        Document doc = null;
        try {
            doc = Jsoup
                    .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
                    .userAgent("Mozilla/5.0")
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }

        return doc;
    }
}
package ifmgbot;

import java.io.IOException;
import org.jsoup.nodes.Element;
import java.io.IOException;
import org.jsoup.Jsoup;

public class Connect {
    public void createConnection()
    {
        try {
            Element doc = Jsoup
                    .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
                    .userAgent("Mozilla/5.0")
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }
    }
}

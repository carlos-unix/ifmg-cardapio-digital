package ifmgbot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Scrapper {

    public static void main(String[] args) {

        try {
            Document doc = Jsoup
                    .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
                    .userAgent("Mozilla/5.0")
                    .get();

            Element menuTable = doc.selectFirst("table");
            if (menuTable == null) {
                System.out.println("A tabela não existe.");
                return;
            }
            Elements days = menuTable.select("thead th");
            for (Element day : days) {
                System.out.println(day.text());
            }

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }
    }
}
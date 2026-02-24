package ifmgbot;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// function to create connection
/* NOTA: nem todos os campus estão disponíveis para consultar o cardápio digital, por isso há apenas alguns links de conexão. */

public class Connect {
    public static String UserAgent = "Mozilla/5.0";
    public static Document doc = null;

    public static Document createConnectionSJE() {
        try {
            doc = Jsoup
                    .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
                    .userAgent(UserAgent)
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }

        return doc;
    }

    public static Document createConnectionGVA() {
        try {
            doc = Jsoup
                    .connect("https://www.ifmg.edu.br/governadorvaladares/central-de-servicos/cardapio-restaurante")
                    .userAgent(UserAgent)
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }

        return doc;
    }

    public static Document createConnectionOUP() {
        try {
            doc = Jsoup
                    .connect("https://ouropreto.ifmg.edu.br/ouropreto/central-de-servicos/cardapio-restaurante")
                    .userAgent(UserAgent)
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }

        return doc;
    }

    public static Document createConnectionFOR() {
        try {
            doc = Jsoup
                    .connect("https://plone.ifmg.edu.br/formiga/central-de-servicos/cardapio-restaurante")
                    .userAgent(UserAgent)
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }

        return doc;
    }
}
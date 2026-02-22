package ifmgbot;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Connect {
    // function to create connection
    public static Document createConnectionSJE() {
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

    // public static Document createConnectionCNG() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.meep.cloud/9876c3b3-d9a2-7cfb-db21-463876970292")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    // public static Document createConnectionCNL() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    public static Document createConnectionGVA() {
        Document doc = null;
        try {
            doc = Jsoup
                    .connect("https://www.ifmg.edu.br/governadorvaladares/central-de-servicos/cardapio-restaurante")
                    .userAgent("Mozilla/5.0")
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }

        return doc;
    }

    // public static Document createConnectionPIU() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    // public static Document createConnectionOUB() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    public static Document createConnectionOUP() {
        Document doc = null;
        try {
            doc = Jsoup
                    .connect("https://ouropreto.ifmg.edu.br/ouropreto/central-de-servicos/cardapio-restaurante")
                    .userAgent("Mozilla/5.0")
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }

        return doc;
    }

    // public static Document createConnectionIPA() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    // public static Document createConnectionITA() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    // public static Document createConnectionRIB() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    // public static Document createConnectionSAB() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    public static Document createConnectionFOR() {
        Document doc = null;
        try {
            doc = Jsoup
                    .connect("https://plone.ifmg.edu.br/formiga/central-de-servicos/cardapio-restaurante")
                    .userAgent("Mozilla/5.0")
                    .get();

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site:");
            e.printStackTrace();
        }

        return doc;
    }
    

    // public static Document createConnectionSAN() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

    // public static Document createConnectionARC() {
    //     Document doc = null;
    //     try {
    //         doc = Jsoup
    //                 .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
    //                 .userAgent("Mozilla/5.0")
    //                 .get();

    //     } catch (IOException e) {
    //         System.out.println("Erro ao acessar o site:");
    //         e.printStackTrace();
    //     }

    //     return doc;
    // }

//     public static Document createConnectionBET() {
//         Document doc = null;
//         try {
//             doc = Jsoup
//                     .connect("https://cardapio.sje.ifmg.edu.br/cardapio.php")
//                     .userAgent("Mozilla/5.0")
//                     .get();

//         } catch (IOException e) {
//             System.out.println("Erro ao acessar o site:");
//             e.printStackTrace();
//         }

//         return doc;
//     }
// }
}
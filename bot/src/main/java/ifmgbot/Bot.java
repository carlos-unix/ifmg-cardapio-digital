package ifmgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Bot extends TelegramLongPollingBot {

    public void botSendingMessages(Long user, String message) {
        SendMessage sm = SendMessage.builder().chatId(user.toString()).text(message).build();
        try {
            execute(sm); // sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e); // printing errors
        }
    }

    public boolean startCommand = false;

    @Override
    public String getBotUsername() {
        return "IFMGCD_bot";
    }

    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN"); // the original bot token is on my environment variables for privacy reasons
    }

    public void onUpdateReceived(Update update) {
        var userMessage = update.getMessage();
        var user = userMessage.getFrom();
        var id = user.getId();
        var command = userMessage.getText();

        switch (command) {
            case "/start":
                botSendingMessages(id, "Olá, " + user.getFirstName()
                        + ", bem-vindo ao bot IFMG Cardápio Digital. Use /help para saber como utilizar.");
                break;
            case "/help":

                botSendingMessages(id,
                        "Para consultar o cardápio com o nosso bot, digite o código do campus desejado: \n"
                                + "\nCongonhas - /cng"
                                + "\nConselheiro Lafaiete - /cnl"
                                + "\nGovernador Valadares - /gva"
                                + "\nPiumhi - /piu"
                                + "\nOuro Branco - /oub"
                                + "\nOuro Preto - /oup"
                                + "\nIpatinga - /ipa"
                                + "\nItabirito - /ita"
                                + "\nRibeirão das Neves - /rib"
                                + "\nSabará - /sab"
                                + "\nFormiga - /for"
                                + "\nSanta Luzia - /san"
                                + "\nSão João Evangelista - /sje"
                                + "\nBetim - /bet"
                                + "\nArcos - /arc");
                break;
            case "/cng":
                Document cng = Connect.createConnectionCNG();
                break;
            case "/cnl":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");
                break;
            case "/gva":
                Document gva = Connect.createConnectionGVA();
                break;
            case "/piu":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;
            case "/oub":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;
            case "/oup":
                Document oup = Connect.createConnectionOUP();

                Elements menuOup = oup.getElementsByClass("row");
                if (menuOup == null) {
                    System.out.println("A tabela não existe.");
                    return;
                }

                Elements itemsOup = menuOup.select("h4");

                if (!(itemsOup.isEmpty())) {
                    for (Element item : itemsOup) {
                        System.out.println(item.text());
                        Elements days = menuOup.select("p");

                        for (Element day : days) {
                            System.out.println(day.text());
                        }
                    }

                } else {
                    botSendingMessages(id, "O cardápio ainda não foi lançado pelo serviço de Nutrição.");
                }

                break;
            case "/ipa":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;
            case "/ita":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;
            case "/rib":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;
            case "/sab":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;
            case "/for":
                Document form = Connect.createConnectionFOR();
                Element menuForm = form.getElementById("parent-fieldname-text");
                if (menuForm == null) {
                    System.out.println("Cardápio não encontrado.");
                    return;
                }

                Elements itemsForm = menuForm.select("p");

                if (!(itemsForm.isEmpty())) {
                    for (Element item : itemsForm) {
                        System.out.println(item.text());
                    }
                } else {
                    botSendingMessages(id, "O cardápio ainda não foi lançado pelo serviço de Nutrição.");
                }
                break;
            case "/san":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;
            case "/sje":
                Document sje = Connect.createConnectionSJE();

                Element menuSje = sje.selectFirst("table");
                if (menuSje == null) {
                    System.out.println("A tabela não existe.");
                    return;
                }

                Elements itemsSje = menuSje.select("tbody td");

                if (!(itemsSje.isEmpty())) {
                    for (Element item : itemsSje) {
                        System.out.println(item.text());
                    }
                    Elements days = menuSje.select("thead th");
                    for (Element day : days) {
                        System.out.println(day.text());
                    }
                } else {
                    botSendingMessages(id, "O cardápio ainda não foi lançado pelo serviço de Nutrição.");
                }
                break;
            case "/bet":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;
            case "/arc":
                botSendingMessages(id, "O cardápio deste campus não está disponível na web.");

                break;

            default:
                botSendingMessages(id, "Este comando não existe.");
                break;
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }

}

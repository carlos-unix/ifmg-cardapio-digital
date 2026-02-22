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

    Document conn = Connect.createConnection();

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
                break;
            case "/cnl":
                break;
            case "/gva":
                break;
            case "/piu":
                break;
            case "/oub":
                break;
            case "/oup":
                break;
            case "/ipa":
                break;
            case "/ita":
                break;
            case "/rib":
                break;
            case "/sab":
                break;
            case "/for":
                break;
            case "/san":
                break;
            case "/sje":
                Element menuTable = conn.selectFirst("table");
                if (menuTable == null) {
                    System.out.println("A tabela não existe.");
                    return;
                }

                Elements items = menuTable.select("tbody td");

                if (!(items.isEmpty())) {
                    for (Element item : items) {
                        System.out.println(item.text());
                    }
                    Elements days = menuTable.select("thead th");
                    for (Element day : days) {
                        System.out.println(day.text());
                    }
                } else {
                    botSendingMessages(id, "O cardápio ainda não foi lançado pelo serviço de Nutrição.");
                }
                break;
            case "/bet":
                break;
            case "/arc":
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

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
            execute(sm);
        } catch (org.telegram.telegrambots.meta.exceptions.TelegramApiException e) {
        }
    }

    public void notLaunchedMenu(Long user) {
        botSendingMessages(user, "O cardápio não foi registrado pelo serviço de Nutrição.");
    }

    public void notFoundMenu(Long user) {
        botSendingMessages(user, "O cardápio deste campus não existe na web. ");
    }

    public void menuNotExists(Long user) {
        botSendingMessages(user, "Cardápio não encontrado.");
    }

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

        if (userMessage.isCommand()) {
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
                    botSendingMessages(id,
                            "O cardápio deste campus é inacessível por ser lançado via API independente.");
                    break;

                case "/cnl":
                    notFoundMenu(id);
                    break;

                case "/gva":
                    Document gva = Connect.createConnection(
                            "https://www.ifmg.edu.br/governadorvaladares/central-de-servicos/cardapio-restaurante");

                    Element menuGva = gva.getElementById("parent-fieldname-text");
                    if (menuGva == null) {
                        menuNotExists(id);
                        return;
                    }

                    Elements itemsGva = menuGva.select("p");

                    if (!(itemsGva.isEmpty())) {
                        for (Element item : itemsGva) {
                            botSendingMessages(id, item.text());
                        }
                    } else {
                        notLaunchedMenu(id);
                    }
                    break;

                case "/piu":
                    notFoundMenu(id);
                    break;

                case "/oub":
                    notFoundMenu(id);
                    break;

                case "/oup":
                    Document oup = Connect.createConnection(
                            "https://ouropreto.ifmg.edu.br/ouropreto/central-de-servicos/cardapio-restaurante");

                    Elements menuOup0 = oup.getElementsByClass("cell width-3 position-0 ");
                    if (menuOup0 == null) {
                        menuNotExists(id);
                        return;
                    }

                    Elements itemsOup0 = menuOup0.select("h4");

                    if (!(itemsOup0.isEmpty())) {
                        for (Element item : itemsOup0) {
                            botSendingMessages(id, item.text());
                            Elements days = menuOup0.select("p");

                            for (Element day : days) {
                                botSendingMessages(id, day.text());
                            }
                        }

                    } else {
                        notLaunchedMenu(id);
                    }

                    Elements menuOup1 = oup.getElementsByClass("cell width-3 position-3 ");
                    if (menuOup1 == null) {
                        menuNotExists(id);

                        return;
                    }

                    Elements itemsOup1 = menuOup1.select("h4");

                    if (!(itemsOup1.isEmpty())) {
                        for (Element item : itemsOup1) {
                            botSendingMessages(id, item.text());
                            Elements days = menuOup1.select("p");

                            for (Element day : days) {
                                botSendingMessages(id, day.text());
                            }
                        }

                    } else {
                        notLaunchedMenu(id);
                    }

                    Elements menuOup2 = oup.getElementsByClass("cell width-3 position-6 ");
                    if (menuOup2 == null) {
                        menuNotExists(id);

                        return;
                    }

                    Elements itemsOup2 = menuOup2.select("h4");

                    if (!(itemsOup2.isEmpty())) {
                        for (Element item : itemsOup2) {
                            botSendingMessages(id, item.text());
                            Elements days = menuOup2.select("p");

                            for (Element day : days) {
                                botSendingMessages(id, day.text());
                            }
                        }

                    } else {
                        notLaunchedMenu(id);
                    }

                    Elements menuOup3 = oup.getElementsByClass("cell width-3 position-9 ");
                    if (menuOup3 == null) {
                        menuNotExists(id);

                        return;
                    }

                    Elements itemsOup3 = menuOup3.select("h4");

                    if (!(itemsOup3.isEmpty())) {
                        for (Element item : itemsOup3) {
                            botSendingMessages(id, item.text());
                            Elements days = menuOup3.select("p");

                            for (Element day : days) {
                                botSendingMessages(id, day.text());
                            }
                        }

                    } else {
                        notLaunchedMenu(id);
                    }

                    Elements menuOup4 = oup.getElementsByClass("cell width-3 position-12 ");
                    if (menuOup4 == null) {
                        menuNotExists(id);

                        return;
                    }

                    Elements itemsOup4 = menuOup4.select("h4");

                    if (!(itemsOup4.isEmpty())) {
                        for (Element item : itemsOup4) {
                            botSendingMessages(id, item.text());
                            Elements days = menuOup4.select("p");

                            for (Element day : days) {
                                botSendingMessages(id, day.text());
                            }
                        }

                    } else {
                        notLaunchedMenu(id);
                    }
                    break;

                case "/ipa":
                    notFoundMenu(id);
                    break;

                case "/ita":
                    notFoundMenu(id);
                    break;

                case "/rib":
                    notFoundMenu(id);
                    break;

                case "/sab":
                    notFoundMenu(id);
                    break;

                case "/for":
                    Document form = Connect.createConnection(
                            "https://plone.ifmg.edu.br/formiga/central-de-servicos/cardapio-restaurante");

                    Element menuForm = form.getElementById("parent-fieldname-text");
                    if (menuForm == null) {
                        menuNotExists(id);
                        return;
                    }

                    Elements itemsForm = menuForm.select("p");

                    if (!(itemsForm.isEmpty())) {
                        for (Element item : itemsForm) {
                            botSendingMessages(id, item.text());

                        }
                    } else {
                        notLaunchedMenu(id);
                    }
                    break;

                case "/san":
                    notFoundMenu(id);
                    break;

                case "/sje":
                    Document sje = Connect.createConnection("https://cardapio.sje.ifmg.edu.br/cardapio.php");

                    Element menuSje = sje.selectFirst("table");
                    if (menuSje == null) {
                        menuNotExists(id);
                        return;
                    }

                    Elements itemsSje = menuSje.select("tbody td");

                    if (!(itemsSje.isEmpty())) {
                        for (Element item : itemsSje) {
                            botSendingMessages(id, item.text());

                        }
                        Elements days = menuSje.select("thead th");
                        for (Element day : days) {
                            botSendingMessages(id, day.text());
                        }
                    } else {
                        notLaunchedMenu(id);
                    }
                    break;

                case "/bet":
                    notFoundMenu(id);
                    break;

                case "/arc":
                    notFoundMenu(id);
                    break;

                default:
                    botSendingMessages(id, "Este comando não existe.");
                    break;
            }
        } else {
            botSendingMessages(id, "No momento não posso conversar por mensagens, apenas por comandos.");
            return;
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }
}
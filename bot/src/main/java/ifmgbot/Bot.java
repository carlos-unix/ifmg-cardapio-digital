package ifmgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
//import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

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
        if (userMessage.getText().equals("/start")) {
            sendStartMessage(id, "Olá, " + user.getFirstName() + ", bem-vindo ao bot IFMG Cardápio Digital.");
        }
    }

    public void sendStartMessage(Long user, String message) {
        botSendingMessages(user, message);
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }

}

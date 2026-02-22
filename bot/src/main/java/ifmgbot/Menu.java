package ifmgbot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Menu {
    private Element day;
    private Element item;

    public Element getDay() {
        return day;
    }

    public void setDay(Element day) {
        this.day = day;
    }

    public Element getItem() {
        return item;
    }

    public void setItem(Element item) {
        this.item = item;
    }

}

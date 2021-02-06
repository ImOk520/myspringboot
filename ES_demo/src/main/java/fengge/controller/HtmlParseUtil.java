package fengge.controller;

import fengge.entity.Good;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Feng, Ge 2020-10-13 20:32
 */
@Slf4j
@Component
public class HtmlParseUtil {

    public static List<Good> parseJD(String keyword) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keyword;
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");

        ArrayList<Good> goods = new ArrayList<Good>();

        for (Element ele : elements) {
            String img = ele.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = ele.getElementsByClass("p-price").eq(0).text();
            String name = ele.getElementsByClass("p-name").eq(0).text();
            System.out.println(img);
            System.out.println(price);
            System.out.println(name);

            Good good = new Good();
            good.setImg(img);
            good.setName(name);
            good.setPrice(price);
            goods.add(good);
        }
        return goods;
    }

}

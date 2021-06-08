package fengge.test.event2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
public class EventController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/user")
    public Goods getUser(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Goods goods = goodsService.getGoods();
        return goods;
    }
}

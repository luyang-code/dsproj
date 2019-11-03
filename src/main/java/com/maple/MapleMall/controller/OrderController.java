package com.maple.MapleMall.controller;

import com.maple.MapleMall.entity.Order;
import com.maple.MapleMall.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    //跳转到首页
    @RequestMapping("/OrderIndex")
    public ModelAndView orderPage(){
        return new ModelAndView("index");
    }

    @ResponseBody
    @RequestMapping("/findAllOrders")
    public List<Order> findAllOrders(){
        return orderService.findAllOrders();
    }

    //搜索订单
    @ResponseBody
    @RequestMapping("/findOrder")
    public List<Order> findUser(@RequestParam Map<String,Object> map){
        String content = (String)map.get("content");
        List<Order> orders = new ArrayList<>();
        if(content.equals("")){
            orders = orderService.findAllOrders();
        }else if(isFindByOrderNum(content)){
            orders=orderService.findOrderByOrderNum(content);
        }else{
            for(Order item:orderService.findOrderByGoodsName(content)){
                orders.addAll(orderService.findOrderByOrderNum(item.getOrderNum()));
            }
        }
        return orders;
    }

    //判断是否通过编号查询
    public static boolean isFindByOrderNum(String str) {
        //以U开头，去除U之后为纯数字
        str=str.replace("-","");
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;

    }
}

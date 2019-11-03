package com.maple.MapleMall.service.impl;

import com.maple.MapleMall.dao.IOrderDao;
import com.maple.MapleMall.entity.Order;
import com.maple.MapleMall.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Order> findAllOrders() {
        //计算金额
        return sumPrice(orderDao.findAllOrders());
    }

    @Override
    public List<Order> findOrderByGoodsName(String goodsName) {
        //计算金额
        return sumPrice(orderDao.findOrderByGoodsName(goodsName));
    }

    @Override
    public List<Order> findOrderByOrderNum(String orderNum) {
        //计算金额
        return sumPrice(orderDao.findOrderByOrderNum(orderNum));
    }

    //计算订单金额
    public List<Order> sumPrice(List<Order> orders){
        orders.forEach(item->{
            item.setTotalPrice(new BigDecimal(item.getOrderGoods().getGoodsPrice()).multiply(new BigDecimal(item.getOrderGoodsCount()))+"");
        });
        return orders;
    }
}

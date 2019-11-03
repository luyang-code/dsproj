package com.maple.MapleMall.service;

import com.maple.MapleMall.entity.Order;

import java.util.List;

public interface IOrderService {
    //查询所有订单
    List<Order> findAllOrders();

    //根据商品名查询订单
    List<Order> findOrderByGoodsName(String goodsName);
    //根据订单编号查询订单信息
    List<Order> findOrderByOrderNum(String orderNum);
}

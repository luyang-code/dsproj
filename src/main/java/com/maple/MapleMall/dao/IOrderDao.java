package com.maple.MapleMall.dao;

import com.maple.MapleMall.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOrderDao {

    //查询所有订单
    List<Order> findAllOrders();

    //根据商品名查询订单
    List<Order> findOrderByGoodsName(String goodsName);
    //根据订单编号查询订单信息
    List<Order> findOrderByOrderNum(String orderNum);
}

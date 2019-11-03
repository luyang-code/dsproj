package com.maple.MapleMall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {

    private Integer orderId;//订单id
    private String orderNum;//订单代码
    private String orderGoodsName;//订单商品名称
    private Integer orderGoodsCount;//订单商品数量
    private int orderDel;//订单删除标记
    private String orderRE;


    private Goods orderGoods;//订单商品对象

    private String totalPrice;//合计金额
}

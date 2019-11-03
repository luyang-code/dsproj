package com.maple.MapleMall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Goods {

    private Integer goodsId;//商品id
    private String goodsNum;//商品代码
    private String goodsName;//商品名称
    private String goodsType;//商品类别
    private String goodsPrice;//商品价格
    private int goodsDel;//商品删除标记
    private String goodsRE;

    private GoodsType goodsTypeObject;//商品类别对象
}

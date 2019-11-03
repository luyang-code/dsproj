package com.maple.MapleMall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsType {

    private Integer goodsTypeId;//商品类别id
    private String goodsTypeNum;//商品类别代码
    private String goodsTypeName;//商品类别名称
    private int goodsTypeDel;//商品删除标记
    private String goodsTypeRE;

    private List<Goods> goods;//商品

}

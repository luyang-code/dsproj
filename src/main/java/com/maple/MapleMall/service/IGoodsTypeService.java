package com.maple.MapleMall.service;

import com.maple.MapleMall.entity.GoodsType;

import java.util.List;
import java.util.Map;

public interface IGoodsTypeService {

    //查询商品类别
    List<GoodsType> findGoodsTypeByName(String goodsTypeName);
    List<GoodsType> findGoodsTypeAll();

    //添加商品类别
    public boolean addGoodsType(GoodsType goodsType);

    //删除商品类别
    public boolean deleteGoodsType(String goodsTypeName);

    //修改商品类别
    public boolean updateByNum(Map map);

}

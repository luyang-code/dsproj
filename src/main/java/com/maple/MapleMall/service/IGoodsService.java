package com.maple.MapleMall.service;

import com.maple.MapleMall.entity.Goods;

import java.util.List;
import java.util.Map;

public interface IGoodsService {

    //查询商品
    List<Goods> findGoodsByName(String goodsName);
    Goods findGoodsByNum(String goodsNum);
    List<Goods> findByType(String goodsTypeName);
    List<Goods> findGoodsAll();
    List<Goods> findGoodsByNumAndName(Map map);

    //添加商品
    public boolean addGoods(Goods goods);

    //删除商品
    public boolean deleteGoods(String goodsNum);

    //修改商品
    public boolean updateGoodsByNum(Map map);

    List<Goods> findType();

}

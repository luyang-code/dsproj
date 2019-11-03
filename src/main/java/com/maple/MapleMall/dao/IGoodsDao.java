package com.maple.MapleMall.dao;

import com.maple.MapleMall.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IGoodsDao {
    //查询商品
    List<Goods> findGoodsByName(String goodsName);
    Goods findGoodsByNum(String goodsNum);
    List<Goods> findByType(String goodsTypeName);
    //查询所有商品
    List<Goods> findGoodsAll();

    List<Goods> findGoodsByNumAndName(Map map);
    //添加商品
    boolean addGoods(Goods goods);
    //删除商品
    boolean deleteGoods(String goodsNum);
    //修改商品
    boolean updateByNum(Map map);

    String findMaxNum();

    List<Goods> findType();
}

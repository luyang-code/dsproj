package com.maple.MapleMall.dao;

import com.maple.MapleMall.entity.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IGoodsTypeDao {

    //根据商品类别名查询
    List<GoodsType> findGoodsTypeByName(String goodsTypeName);
    //根据商品类别查询商品
    List<GoodsType> findGoodsByGoodsType(String goodsType);
    //添加商品类别
    boolean addGoodsType(GoodsType goodsType);
    //删除商品类别
    boolean deleteGoodsType(String goodsTypeName);
    //查询所有商品类别
    List<GoodsType> findGoodsTypeAll();
    //修改商品类别
    boolean updateByNum(Map map);

    String findMaxNum();

}

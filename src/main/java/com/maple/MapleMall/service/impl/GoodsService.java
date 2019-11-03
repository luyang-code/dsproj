package com.maple.MapleMall.service.impl;

import com.maple.MapleMall.dao.IGoodsDao;
import com.maple.MapleMall.entity.Goods;
import com.maple.MapleMall.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsService implements IGoodsService {

    @Autowired
    private IGoodsDao goodsDao;

    @Override
    public List<Goods> findGoodsByName(String goodsName) {
        return goodsDao.findGoodsByName(goodsName);
    }

    @Override
    public Goods findGoodsByNum(String goodsNum) {
        return goodsDao.findGoodsByNum(goodsNum);
    }

    @Override
    public List<Goods> findByType(String goodsTypeName) {
        return goodsDao.findByType(goodsTypeName);
    }

    @Override
    public List<Goods> findGoodsAll() {
        return goodsDao.findGoodsAll();
    }

    @Override
    public List<Goods> findGoodsByNumAndName(Map map) {
        return goodsDao.findGoodsByNumAndName(map);
    }

    @Override
    public boolean addGoods(Goods goods) {
        goods.setGoodsNum(("G"+(Integer.parseInt(goodsDao.findMaxNum().substring(1))+1)));
        return goodsDao.addGoods(goods);
    }

    @Override
    public boolean deleteGoods(String goodsNum) {
        return goodsDao.deleteGoods(goodsNum);
    }

    @Override
    public boolean updateGoodsByNum(Map map) {
        return goodsDao.updateByNum(map);
    }

    @Override
    public List<Goods> findType() {
        return goodsDao.findType();
    }
}

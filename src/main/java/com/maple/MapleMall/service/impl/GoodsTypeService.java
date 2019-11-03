package com.maple.MapleMall.service.impl;

import com.maple.MapleMall.dao.IGoodsTypeDao;
import com.maple.MapleMall.entity.GoodsType;
import com.maple.MapleMall.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsTypeService implements IGoodsTypeService {

    @Autowired
    private IGoodsTypeDao goodsTypeDao;

    @Override
    public List<GoodsType> findGoodsTypeByName(String goodsTypeName) {
        return goodsTypeDao.findGoodsTypeByName(goodsTypeName);
    }

    @Override
    public List<GoodsType> findGoodsTypeAll() {
        return goodsTypeDao.findGoodsTypeAll();
    }

    @Override
    public boolean addGoodsType(GoodsType goodsType) {
        goodsType.setGoodsTypeNum("S"+(Integer.parseInt(goodsTypeDao.findMaxNum().substring(1))+1));
        return goodsTypeDao.addGoodsType(goodsType);
    }

    @Override
    public boolean deleteGoodsType(String goodsTypeName) {
        return goodsTypeDao.deleteGoodsType(goodsTypeName);
    }

    @Override
    public boolean updateByNum(Map map) {
        return goodsTypeDao.updateByNum(map);
    }

}

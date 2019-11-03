package com.maple.MapleMall.controller;

import com.maple.MapleMall.entity.Goods;
import com.maple.MapleMall.entity.GoodsType;
import com.maple.MapleMall.service.IGoodsService;
import com.maple.MapleMall.service.IGoodsTypeService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IGoodsTypeService goodsTypeService;

    @RequestMapping("/goodsList")
    public ModelAndView goodsList(){
        return new ModelAndView("goodsList");
    }

    @ResponseBody
    @RequestMapping("/findGoodsAll")
    public List<Goods> findGoodsAll(){
        return goodsService.findGoodsAll();
    }

    @ResponseBody
    @RequestMapping("/findGoodsBy")
    public List<Goods> findGoodsBy(@RequestParam Map<String,Object> map){
        if(((String)map.get("name")).equals("")){
            if(!((String)map.get("type")).equals("")){
                return goodsService.findByType((String) map.get("type"));
            }else {
                return goodsService.findGoodsAll();
            }
        }else {
            if(((String)map.get("type")).equals("")){
               return goodsService.findGoodsByName((String) map.get("name"));
            }else {
                Map map1=new HashMap();
                map1.put("goodsName",(String)map.get("name"));
                map1.put("goodsTypeName",(String)map.get("type"));
                return goodsService.findGoodsByNumAndName(map1);
            }

        }
    }

    //添加商品
    @ResponseBody
    @RequestMapping("/addGoods")
    public boolean addGoods(@RequestParam Map<String,Object> map){
        Goods goods=new Goods();
        goods.setGoodsName((String) map.get("goodsName"));
        goods.setGoodsType(goodsTypeService.findGoodsTypeByName((String) map.get("goodsCategory")).get(0).getGoodsTypeNum());
        goods.setGoodsPrice((String)map.get("goodsPrice"));
        return goodsService.addGoods(goods);
    }

    //删除商品
    @ResponseBody
    @RequestMapping("/delGoods/{goodsNum}")
    public boolean delGoods(@PathVariable("goodsNum") String goodsNum){
        return goodsService.deleteGoods(goodsNum);
    }

    //修改商品
    @ResponseBody
    @RequestMapping("/changeGoods")
    public boolean changeGoods(@RequestParam Map<String,Object> map){
        Map map1=new HashMap();
        map1.put("goodsNum",(String)map.get("goodsNum"));
        map1.put("goodsName",(String)map.get("goodName"));
        map1.put("goodsType",(goodsTypeService.findGoodsTypeByName((String)map.get("GoodType")).get(0).getGoodsTypeNum()));
        map1.put("goodsPrice",(String)map.get("GoodPrice"));
        return goodsService.updateGoodsByNum(map1);
    }

    @ResponseBody
    @RequestMapping("/findType")
    public List<Goods> findType(){
        return goodsService.findType();
    }

    @ResponseBody
    @RequestMapping("/findType1")
    public List<GoodsType> findType1(){
        return goodsTypeService.findGoodsTypeAll();
    }

}

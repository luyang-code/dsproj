package com.maple.MapleMall.controller;

import com.maple.MapleMall.entity.GoodsType;
import com.maple.MapleMall.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/GoodsType")
public class GoodsTypeController {

    @Autowired
    private IGoodsTypeService goodsTypeService;

    @RequestMapping("/goodsTypeList")
    public ModelAndView goodsTypeList(){
        return new ModelAndView("goodsTypeList");
    }

    @ResponseBody
    @RequestMapping("/findGoodsTypeAll")
    public List<GoodsType> findGoodsTypeAll(){
        return goodsTypeService.findGoodsTypeAll();
    }

    @ResponseBody
    @RequestMapping("/findGoodsTypeByName/{goodsTypeName}")
    public List<GoodsType> findGoodsTypeByName(@PathVariable("goodsTypeName") String goodsTypeName){
        if (goodsTypeName.equals("")){
            return goodsTypeService.findGoodsTypeAll();
        }
        return goodsTypeService.findGoodsTypeByName(goodsTypeName);
    }

    //添加商品类别
    @ResponseBody
    @RequestMapping("/addGoodsType")
    public boolean addGoodsType(@RequestParam Map<String,Object> map){
        GoodsType goodsType=new GoodsType();
        goodsType.setGoodsTypeName((String) map.get("goodsTypeName"));
        return goodsTypeService.addGoodsType(goodsType);
    }

    //按商品类型名删除商品类别
    @ResponseBody
    @RequestMapping("/delGoodsType/{goodsTypeName}")
    public boolean delGoodsType(@PathVariable("goodsTypeName") String goodsTypeName){
        return goodsTypeService.deleteGoodsType(goodsTypeName);
    }

    //按商品类型编号修改商品类别
    @ResponseBody
    @RequestMapping("/changeGoodsType")
    public boolean changeGoodsType(@RequestParam Map<String,Object> map){
        Map map1=new HashMap();
        map1.put("goodsTypeNum",(String)map.get("goodsTypeNum"));
        map1.put("goodsTypeName",(String)map.get("newGoodsTypeName"));
        return goodsTypeService.updateByNum(map1);
    }

}

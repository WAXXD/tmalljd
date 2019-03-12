package com.cqu.waxxd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqu.waxxd.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.cqu.waxxd.bean.OBJECT_T_MALL_ATTR;
import com.cqu.waxxd.bean.T_MALL_PRODUCT;
import com.cqu.waxxd.bean.T_MALL_SKU;
import com.cqu.waxxd.bean.T_MALL_SKU_ATTR_VALUE;
import com.cqu.waxxd.service.AttrServiceInf;
import com.cqu.waxxd.service.SkuServiceInf;

@Controller
public class SkuController {
	
	@Autowired
	AttrServiceInf attrServiceInf;
	
	@Autowired
	SkuServiceInf skuServicerInf;
	
	@RequestMapping("/goto_sku_add")
	public String goto_sku_add(int flbh1,int flbh2 ,ModelMap map) {
		
		List<OBJECT_T_MALL_ATTR> list_attr = attrServiceInf.get_attr_list(flbh2);
		map.put("list_attr", list_attr);
		map.put("flbh1", flbh1);
		map.put("flbh2", flbh2);
		return "skuAdd";
	}
	
	@RequestMapping("/save_sku")
	public ModelAndView save_sku(T_MALL_SKU sku,MODEL_T_MALL_SKU_ATTR_VALUE list_attr,T_MALL_PRODUCT spu) {
		
		skuServicerInf.save_sku(sku,spu,list_attr.getList_attr());
		
		ModelAndView mv = new ModelAndView("redirect:/goto_sku_add.do");
		mv.addObject("flbh1",spu.getFlbh1());
		mv.addObject("flbh2",spu.getFlbh2());
		mv.addObject("pp_id",spu.getPp_id());
		
		
		return mv;
	}
}


























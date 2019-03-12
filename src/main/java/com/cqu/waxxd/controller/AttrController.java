package com.cqu.waxxd.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cqu.waxxd.bean.MODEL_T_MALL_ATTR;
import com.cqu.waxxd.bean.OBJECT_T_MALL_ATTR;
import com.cqu.waxxd.bean.T_MALL_VALUE;
import com.cqu.waxxd.service.AttrServiceInf;


@Controller
public class AttrController {

	@Autowired
	private AttrServiceInf attrServiceInf;
	
	@RequestMapping("/goto_attr_add")
	public String goto_attr_add(int flbh2,ModelMap map) {
		map.put("flbh2", flbh2);
		return "attrAdd";
	}
	
	@RequestMapping("/get_attr_list")
	public String get_attr_list(int flbh2,ModelMap map) {

		List<OBJECT_T_MALL_ATTR> list_attr = new ArrayList<OBJECT_T_MALL_ATTR>();
		list_attr = attrServiceInf.get_attr_list(flbh2);
		map.put("flbh2",flbh2);
		map.put("list_attr", list_attr);
		
		
		return "attrListInner";
	}
	
	@RequestMapping("/get_attr_list_json")
	@ResponseBody
	public List<OBJECT_T_MALL_ATTR> get_attr_list_json(int flbh2) {

		List<OBJECT_T_MALL_ATTR> list_attr = new ArrayList<OBJECT_T_MALL_ATTR>();
		list_attr = attrServiceInf.get_attr_list(flbh2);
		
		
		return list_attr;
	}
	
	@RequestMapping("/attr_add")
	public ModelAndView attr_add(int flbh2,MODEL_T_MALL_ATTR list_attr1) {
		
		List<OBJECT_T_MALL_ATTR> list_attr = list_attr1.getList_attr();
		attrServiceInf.save_attr(flbh2,list_attr);
		
		ModelAndView mv = new ModelAndView("redirect:/index.do");//goto_attr_add.do
		//mv.addObject("flbh2",flbh2);
		mv.addObject("url","goto_attr_add.do?flbh2="+flbh2);
		mv.addObject("title","添加属性");
		
		return mv; 
	}
}

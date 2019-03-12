package com.cqu.waxxd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cqu.waxxd.bean.T_MALL_PRODUCT;
import com.cqu.waxxd.service.SpuServiceImpl;
import com.cqu.waxxd.service.SpuServiceInf;
import com.cqu.waxxd.utils.MyFileUpload;

@Controller
public class SpuController {
	
	@Autowired
	private SpuServiceInf spuServiceInf;
	
	@RequestMapping("/goto_spu_add")
	public String goto_spu_add(ModelMap map,T_MALL_PRODUCT spu) {
		map.put("spu",spu);
		return "spuAdd";
	}
	
	/**
	 * 
	 * @param files 商品图片文件
	 * @param spu
	 * @return 回到添加商品页面
	 */
	@RequestMapping("/spu_add")
	public ModelAndView spu_add(@RequestParam("files") MultipartFile[] files,T_MALL_PRODUCT spu) {
		
		List<String> list_images = MyFileUpload.upload_images(files);
		ModelAndView mv = new ModelAndView("redirect:/goto_spu_add.do");
		spuServiceInf.save_spu(list_images,spu);
		mv.addObject("flbh1",spu.getFlbh1());
		mv.addObject("flbh2",spu.getFlbh2());
		mv.addObject("pp_id",spu.getPp_id());
		
		return mv;
	}
	
	@RequestMapping("/get_spu_list")
	@ResponseBody
	public List<T_MALL_PRODUCT> get_spu_list(int pp_id,int flbh2) {
		
		List<T_MALL_PRODUCT> list_spu = spuServiceInf.get_spu_list(pp_id,flbh2);
		
		return list_spu;
	}
	
}























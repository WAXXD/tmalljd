package com.cqu.waxxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/goto_attr.do")
	public String goto_attr() {

		return "attr";
	}

	@RequestMapping("/index.do")
	public String index(String url, String title, ModelMap map) {

		map.put("url", url);
		map.put("title", title);
		return "main";
	}

	@RequestMapping("/goto_spu.do")
	public String goto_spu() {

		return "spu";
	}

	@RequestMapping("/goto_sku.do")
	public String goto_sku() {

		return "sku";
	}

}

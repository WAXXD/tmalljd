package com.cqu.waxxd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.waxxd.bean.T_MALL_PRODUCT;
import com.cqu.waxxd.bean.T_MALL_SKU;
import com.cqu.waxxd.bean.T_MALL_SKU_ATTR_VALUE;
import com.cqu.waxxd.mapper.SkuMapper;

@Service
public class SkuServiceImpl implements SkuServiceInf {
	
	@Autowired
	SkuMapper skuMapper;
	
	
	@Override
	public void save_sku(T_MALL_SKU sku, T_MALL_PRODUCT spu, List<T_MALL_SKU_ATTR_VALUE> list_attr) {
		
		sku.setShp_id(spu.getId());
		skuMapper.insert_sku(sku);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("shp_id", spu.getId());
		map.put("sku_id", sku.getId());
		map.put("list_av", list_attr);
		skuMapper.insert_sku_av(map);
		
	}

}
package com.cqu.waxxd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.waxxd.bean.T_MALL_PRODUCT;
import com.cqu.waxxd.mapper.SpuMapper;
@Service
public class SpuServiceImpl implements SpuServiceInf{
	
	@Autowired
	private SpuMapper spuMapper;
	
	@Override
	public void save_spu(List<String> list_image, T_MALL_PRODUCT spu) {
		//插入spu信息
		spu.setShp_tp(list_image.get(0));
		spuMapper.insertSpu(spu);
		
		Map<Object, Object> map = new HashMap<>();
		map.put("shp_id", spu.getId());
		map.put("list_image", list_image);
		spuMapper.insert_images(map);
	}

	@Override
	public List<T_MALL_PRODUCT> get_spu_list(int pp_id, int flbh2) {
		Map< Object, Object> map = new HashMap<>();
		map.put("pp_id", pp_id);
		map.put("flbh2", flbh2);
		List<T_MALL_PRODUCT> list_spu = spuMapper.select_spu_list(map);
		
		return list_spu;
	}

}

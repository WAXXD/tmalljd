package com.cqu.waxxd.mapper;

import java.util.List;
import java.util.Map;

import com.cqu.waxxd.bean.T_MALL_PRODUCT;

public interface SpuMapper {
	
	public void insertSpu(T_MALL_PRODUCT spu);

	public void insert_images(Map<Object, Object> map);

	public List<T_MALL_PRODUCT> select_spu_list(Map<Object, Object> map);
}

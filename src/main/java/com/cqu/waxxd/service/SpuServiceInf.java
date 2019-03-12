package com.cqu.waxxd.service;

import java.util.List;

import com.cqu.waxxd.bean.T_MALL_PRODUCT;

public interface SpuServiceInf {

	public void save_spu(List<String> list_images, T_MALL_PRODUCT spu);

	public List<T_MALL_PRODUCT> get_spu_list(int pp_id, int flbh2);

}
package com.cqu.waxxd.service;

import java.util.List;

import com.cqu.waxxd.bean.T_MALL_PRODUCT;
import com.cqu.waxxd.bean.T_MALL_SKU;
import com.cqu.waxxd.bean.T_MALL_SKU_ATTR_VALUE;

public interface SkuServiceInf {

	void save_sku(T_MALL_SKU sku, T_MALL_PRODUCT spu, List<T_MALL_SKU_ATTR_VALUE> list_attr);

}

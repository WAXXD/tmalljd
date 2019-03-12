package com.cqu.waxxd.service;

import java.util.List;

import com.cqu.waxxd.bean.OBJECT_T_MALL_ATTR;

public interface AttrServiceInf {

	public void save_attr(int flbh2, List<OBJECT_T_MALL_ATTR> list_attr);

	public List<OBJECT_T_MALL_ATTR> get_attr_list(int flbh2);

}

package com.cqu.waxxd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.waxxd.bean.OBJECT_T_MALL_ATTR;
import com.cqu.waxxd.mapper.AttrMapper;

@Service
public class AttrServiceImpl implements AttrServiceInf{

	@Autowired
	private AttrMapper attrMapper;
	
	@Override
	public void save_attr(int flbh2, List<OBJECT_T_MALL_ATTR> list_attr) {
		for(int i = 0;i < list_attr.size();i++) {
			OBJECT_T_MALL_ATTR attr = list_attr.get(i);
			attrMapper.insert_attr(flbh2, attr);
			
			attrMapper.insert_values(attr.getId(), attr.getList_value());
			
		}
	}

	@Override
	public List<OBJECT_T_MALL_ATTR> get_attr_list(int flbh2) {
		List<OBJECT_T_MALL_ATTR> list_attr = attrMapper.select_attr_list(flbh2);
		return list_attr;
	}

}

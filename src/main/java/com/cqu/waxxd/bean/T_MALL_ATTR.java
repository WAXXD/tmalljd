package com.cqu.waxxd.bean;

import java.util.Date;

public class T_MALL_ATTR {

	private int id;
	private String shxm_mch;
	private String shfgy;
	private int flbh2;
	private Date chjshj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShxm_mch() {
		return shxm_mch;
	}

	public void setShxm_mch(String shxm_mch) {
		this.shxm_mch = shxm_mch;
	}

	public String getShfgy() {
		return shfgy;
	}

	public void setShfgy(String shfgy) {
		this.shfgy = shfgy;
	}

	public int getFlbh2() {
		return flbh2;
	}

	public void setFlbh2(int flbh2) {
		this.flbh2 = flbh2;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

	@Override
	public String toString() {
		return "T_MALL_ATTR [id=" + id + ", shxm_mch=" + shxm_mch + ", shfgy=" + shfgy + ", flbh2=" + flbh2
				+ ", chjshj=" + chjshj + "]";
	}

}

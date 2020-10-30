package com.neuedu.pojo;

/**
 * 一对一的关键词association。多对多用collection
 * @author Administrator
 *
 */
public class Wife {
	int w_id;
	String w_name;
	Husband hus;
	
	/**
	 * @return the hus
	 */
	public Husband getHus() {
		return hus;
	}
	/**
	 * 一对多的映射可以看做wife中有一个hus对象
	 */
	public void setHus(Husband hus) {
		this.hus = hus;
	}
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Wife [w_id=" + w_id + ", w_name=" + w_name + ", hus=" + hus.toString() + "]";
	}
	
	
}

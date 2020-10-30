package com.neuedu.pojo;

public class Husband {
	int h_id;
	String h_name;
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Husband [h_id=" + h_id + ", h_name=" + h_name + "]";
	}
	
}

package com.neuedu.pojo;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unused")
public class Dept {
	private int deptno;
    private String dname;
    private String loc;
    //一对多
    //一个部门有多个员工 ，一个实体里的属性为list类型
    private List<Emp> emps;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
//		StringBuffer sb = new StringBuffer("");
//		
//		for (Iterator<Emp> iterator = emps.iterator(); iterator.hasNext();) {
//			Emp emp = (Emp) iterator.next();
//			sb.append(emp.toString()+"\n");
//		}
//		String sbatr = sb.toString();
//		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", emps=\n" + sbatr + "]";
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", emps=\n" + emps + "]";
	}
    
    
}

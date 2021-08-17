package com.example.demo;

public class Product {
	
	private String cid;
	private String pid;
	private String pname;
	private String pdesc;
	
	public Product(String cid,String pid,String pname, String pdesc) {
		this.cid=cid;
		this.pid=pid;
		this.pname=pname;
		this.pdesc=pdesc;
	}
	@Override
	public String toString() {
		return "Product [cid=" + cid + ", pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + "]";
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	

}

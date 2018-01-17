package com.xdl.beetsql.model;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.SeqID;
public class SysUser{

	private Integer sId ;
	private String sName ;
	
	public SysUser() {
	}
	
	@AssignID("uuid2")
	public Integer getsId(){
		return  sId;
	}
	public void setsId(Integer sId ){
		this.sId = sId;
	}
	
	public String getsName(){
		return  sName;
	}
	public void setsName(String sName ){
		this.sName = sName;
	}
	
	
}

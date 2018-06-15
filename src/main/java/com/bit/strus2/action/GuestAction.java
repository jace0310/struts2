package com.bit.strus2.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.bit.struts2.model.GuestDao;
import com.bit.struts2.model.entity.GuestVo;
import com.opensymphony.xwork2.ModelDriven;

public class GuestAction implements ModelDriven<GuestVo>{
	//POJO
	
	GuestDao dao = new GuestDao();
	Logger log =Logger.getLogger(getClass());
	
	private List<GuestVo> list;
	private String msg;
	private int idx;
	private GuestVo bean=new GuestVo();
	
	private List<GuestVo> getList(){
		return list;
	}
	
	private void getMsg() {
		return;
	}
	
	private void setMsg(String msg) {
		this.msg=msg;

	}
	
	public void setIdx(int idx){
		this.idx = idx;
	}
	
	public void setBean(GuestVo bean) {
		this.bean = bean;
	}
	
	public String detail()throws Exception{
		
		log.debug("detail()");
		
		dao.selectOne(idx);
		
		return "success";
	}
	
	public String list() throws Exception {
		GuestDao dao = new GuestDao();
		list=dao.selectAll();
		
		return "success";
	}
	
	public String execute() throws Exception{
		
		return "success";
	}
	
	public String selectOne() throws Exception{
		bean = dao.selectOne(idx);
		return "success";
	}
	
	public String add() throws Exception{
		dao.insertOne(bean);
		
		return "success";
	}

	@Override
	public GuestVo getModel() {
		
		return null;
	}

}

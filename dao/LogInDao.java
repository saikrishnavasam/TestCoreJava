package dao;

import java.util.HashMap;

import bean.LogInBean;

public class LogInDao {
	LogInBean cb = new LogInBean();
	
	HashMap<String,LogInBean> hm = new HashMap<String,LogInBean>();
	
	public LogInDao() {
		super();
	}
	
	public LogInDao(LogInBean cb) {
		this.cb = cb;
		hm.put(cb.getUserName(), cb);
	}
		
	public HashMap<String,LogInBean> hm(){
		return hm;
	}
}
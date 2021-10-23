package com.himansusahoo.FileAPI.bean;

public class Response {
	
	private int status;
	private String desc;
	
	public Response() {
		
	}

	public Response(int status, String desc) {
		super();
		this.status = status;
		this.desc = desc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", desc=" + desc + "]";
	}
	
	

}

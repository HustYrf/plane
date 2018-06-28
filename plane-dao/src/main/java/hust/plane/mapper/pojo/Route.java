package hust.plane.mapper.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Route {
	
	private String routeId;
	private String status;
	private String routePath;
	private String descripte;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateTime;
	
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoutePath() {
		return routePath;
	}
	public void setRoutePath(String routePath) {
		this.routePath = routePath;
	}
	public String getDescripte() {
		return descripte;
	}
	public void setDescripte(String descripte) {
		this.descripte = descripte;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	

}

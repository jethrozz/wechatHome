package com.wechat.model;

/**
 * Created by zxc on 2018/2/22.
 */
public class LocationEvent extends BaseEvent {
	private String latitude;
	private String longitude;
	private String precosion;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecosion() {
		return precosion;
	}

	public void setPrecosion(String precosion) {
		this.precosion = precosion;
	}
}

package com.redsun.platf.entity.sys;

/**
 * Sys109mId generated by hbm2java
 */
public class Sys109mId implements java.io.Serializable {

	private String sid;
	private String osHost;

	public Sys109mId() {
	}

	public Sys109mId(String sid, String osHost) {
		this.sid = sid;
		this.osHost = osHost;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getOsHost() {
		return this.osHost;
	}

	public void setOsHost(String osHost) {
		this.osHost = osHost;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Sys109mId))
			return false;
		Sys109mId castOther = (Sys109mId) other;

		return ((this.getSid() == castOther.getSid()) || (this.getSid() != null
				&& castOther.getSid() != null && this.getSid().equals(
				castOther.getSid())))
				&& ((this.getOsHost() == castOther.getOsHost()) || (this
						.getOsHost() != null
						&& castOther.getOsHost() != null && this.getOsHost()
						.equals(castOther.getOsHost())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result
				+ (getOsHost() == null ? 0 : this.getOsHost().hashCode());
		return result;
	}

}